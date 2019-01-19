package com.usco.project.message.request;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * CategoryForm
 */
public class CategoryForm {

    @NotBlank
    @Size(min=3, max=40)
    private String name;
    
    @Size(min=0, max=1000)
    private String info;

    @Size(min=0, max=300)
    private String icon;

    @Size(min=1, max=10)
    private String state;


    public CategoryForm(String name, String info, String icon, String state) {
        this.name = name;
        this.info = info;
        this.icon = icon;
        this.state = state;
    }    

    public CategoryForm() {
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

}