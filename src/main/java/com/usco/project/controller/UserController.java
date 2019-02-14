package com.usco.project.controller;

import com.usco.project.entity.User;
import com.usco.project.message.request.RecoverPassForm;
import com.usco.project.message.response.Response;
import com.usco.project.service.EmailService;
import com.usco.project.service.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    @Qualifier("servicio_user")
    private UserServices userService;

    @Autowired
    @Qualifier("email_service")
    private EmailService emailService;

    @PostMapping("/recuperarContraseña")
    public Response recuperarContraseña(@RequestBody RecoverPassForm recoverPassForm) {
        User user = userService.getUserInformation(recoverPassForm.getUsername());
        if (user != null) {
            try {
                emailService.sendComplexMessage(recoverPassForm.getEmail(), "/api/v1/user/recuperarContraseña/"+user.getId());
                Response response = new Response(true, "El mensaje de recuperacion fue enviado");
                return response;
            } catch (Exception e) {
                Response response = new Response(false, "Hubo un error al enviar el email");
                response.setError(e.toString());
                return response;
            }
            
        }else{
            Response response = new Response(false, "No existe el nombre de usuario");
            return response;
        }
    }
}