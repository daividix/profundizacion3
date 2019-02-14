package com.usco.project.message.request;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class RecoverPassForm {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min=3, max=40)
    private String username;


    public RecoverPassForm(String email, String username) {
        this.email = email;
        this.username = username;
    }


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}