package com.usco.project.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.usco.project.message.request.LoginForm;
import com.usco.project.message.request.SignUpForm;
import com.usco.project.message.response.JwtResponse;
import com.usco.project.message.response.ResponseMessage;
import com.usco.project.entity.Role;
import com.usco.project.entity.RoleName;
import com.usco.project.entity.User;
import com.usco.project.repository.RoleRepository;
import com.usco.project.repository.UserRepository;
import com.usco.project.security.jwt.JwtProvider;
import com.usco.project.service.UserServices;
 
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {
 
	@Autowired
	AuthenticationManager authenticationManager;
 
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	@Qualifier("servicio_user")
	private UserServices userService;
 
	@Autowired
	RoleRepository roleRepository;
 
	@Autowired
	PasswordEncoder encoder;
 
	@Autowired
	JwtProvider jwtProvider;
 
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
 
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
 
		SecurityContextHolder.getContext().setAuthentication(authentication);
 
		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
 
		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}
 
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!", false),
					HttpStatus.BAD_REQUEST);
		}
 
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!", false),
					HttpStatus.BAD_REQUEST);
		}
 
		// Creating user's account
		String image;
		if (signUpRequest.getImage() != null) {
			image = signUpRequest.getImage();
		} else {
			image = "";
		}
		User user = new User(signUpRequest.getName(), signUpRequest.getLastName(),
				signUpRequest.getGender(), image, signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));
 
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
 
		if(signUpRequest.getSecret() != null) {
			if(signUpRequest.getSecret().equals("s3c8et")) {
				strRoles.forEach(role -> {
					switch (role) {
					case "admin":
						Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
								.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
						roles.add(adminRole);
		 
						break;
					case "pm":
						Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
								.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
						roles.add(pmRole);
		 
						break;
					default:
						Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
								.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
						roles.add(userRole);
					}
				});
			}else {
				return new ResponseEntity<>(new ResponseMessage("Fail -> Secret invalid", false),
						HttpStatus.BAD_REQUEST);
			}
		}else {
			Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			roles.add(userRole);
		}
 
		user.setRoles(roles);
		userRepository.save(user);
 
		return new ResponseEntity<>(new ResponseMessage("User registered successfully!", true), HttpStatus.OK);
	}
	
	@GetMapping("/getuser")
	@PreAuthorize("hasRole('PM') or hasRole('ADMIN') or hasRole('USER')")
	public Hashtable<Object,Object> getUser(Principal principal) {
		Hashtable<Object,Object> response = new Hashtable<Object, Object>();
		User user = userService.getUserInformation(principal.getName().toString());
		response.put("user", user);
		return response;
	}
}
