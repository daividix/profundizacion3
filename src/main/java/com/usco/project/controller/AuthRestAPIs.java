package com.usco.project.controller;

import java.security.Principal;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
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
import com.usco.project.message.response.Response;
import com.usco.project.entity.Role;
import com.usco.project.entity.RoleName;
import com.usco.project.entity.Session;
import com.usco.project.entity.User;
import com.usco.project.repository.RoleRepository;
import com.usco.project.repository.UserRepository;
import com.usco.project.security.CryptPassword;
import com.usco.project.security.jwt.JwtProvider;
import com.usco.project.service.EmailService;
import com.usco.project.service.SessionService;
import com.usco.project.service.UserServices;
 
@RestController
@RequestMapping("/api/v1/auth")
public class AuthRestAPIs {
 
	@Autowired
	AuthenticationManager authenticationManager;
 
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	@Qualifier("servicio_user")
	private UserServices userService;

	@Autowired
	@Qualifier("email_service")
	private EmailService emailService;

	@Autowired
	@Qualifier("session_service")
	private SessionService sessionService;
 
	@Autowired
	RoleRepository roleRepository;
 
	@Autowired
	PasswordEncoder encoder;
 
	@Autowired
	JwtProvider jwtProvider;
 
	@PostMapping("/signin")
	public Response authenticateUser(@Valid @RequestBody LoginForm loginRequest, HttpServletRequest req) {
		System.out.print("Ip = "+req.getRemoteAddr());
		User user = userRepository.getInfoUser(loginRequest.getUsername());
		if (user == null) {
			return new Response(false, "Usuario o contraseña incorrecta");
		}
		CryptPassword cryptPassword = new CryptPassword();
		if (!cryptPassword.compare(loginRequest.getPassword(), user.getPassword())) {
			return new Response(false, "Usuario o contraseña incorrecta");
		}
		try {
			Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
				SecurityContextHolder.getContext().setAuthentication(authentication);
 
				String jwt = jwtProvider.generateJwtToken(authentication);
				UserDetails userDetails = (UserDetails) authentication.getPrincipal();
				Date dateSession = new Date();
				Session newSession = new Session(user, dateSession, req.getRemoteAddr());
				Boolean isSession = sessionService.addSession(newSession);
				Response response = new Response();
				if (isSession) {
					response.setIsOk(true);
					response.setMessage("Usuario logueado correctamente");
					response.setResult(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
					return response;
				}else{
					response.setIsOk(false);
					response.setMessage("No se pudo guardar la session");
					return response;
				}
		} catch (Exception e) {
			Response response = new Response(false, "Ocurrio un error en la autenticacion");
			response.setError(e.toString());
			return response;
		}
	}
 
	@PostMapping("/signup")
	public Response registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new Response(false, "El usuario ya existe");
		}
 
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new Response(false, "El email ya esta registrado");
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
				encoder.encode(signUpRequest.getPassword()), 2);
 
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
 
		if(signUpRequest.getSecret() != null) {
			if(signUpRequest.getSecret().equals("s3c8et")) {
				strRoles.forEach(role -> {
					switch (role) {
					case "ROLE_ADMIN":
						Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
								.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
						roles.add(adminRole);
		 
						break;
					case "ROLE_ADMIN_SITE":
						Role pmRole = roleRepository.findByName(RoleName.ROLE_ADMIN_SITE)
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
				return new Response(false, "Secreto invalido");
			}
		}else {
			Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			roles.add(userRole);
		}
 
		user.setRoles(roles);
		User newUser = userRepository.save(user);
		try {
			System.out.println(emailService.sendComplexMessage(newUser.getEmail(), "/activation/user/"+newUser.getId()));
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return new Response(true, "Usuario registrado satisfactoriamente");
	}
	
	@GetMapping("/getuser")
	@PreAuthorize("hasRole('ADMIN_SITE') or hasRole('ADMIN') or hasRole('USER')")
	public Hashtable<Object,Object> getUser(Principal principal) {
		Hashtable<Object,Object> response = new Hashtable<Object, Object>();
		User user = userService.getUserInformation(principal.getName().toString());
		response.put("isOk", true);
		response.put("user", user);
		return response;
	}
}
