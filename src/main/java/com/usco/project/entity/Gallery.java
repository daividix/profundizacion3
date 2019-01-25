package com.usco.project.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Gallery {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Date date;

    @Column
    private int state;

    @ManyToMany
    private Set<Image> images;

    public Gallery(String name, Date date, int state, Set<Image> images) {
        this.name = name;
        this.date = date;
        this.state = state;
        this.images = images;
    }

    public Gallery() {
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }


    public Set<Image> getImages() {
        return this.images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }


}