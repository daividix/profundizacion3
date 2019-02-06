package com.usco.project.message.request;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class LoginForm {
	
	@NotBlank
	@Size(min=3, max=40)
	private String username;
	
	@NotBlank
    @Size(min = 8, max = 40)
    private String password;
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

}
