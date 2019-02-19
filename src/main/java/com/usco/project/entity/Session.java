package com.usco.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity()
public class Session {

    @Id
    @GeneratedValue
    @Column(unique=true)
    private Long id;

    @ManyToOne
    private User user;

    @Column(nullable=false)
    private Date date;

    @Column(nullable=false)
    private String ip;

    public Session() {

    }


    public Session(User user, Date date, String ip) {
        this.user = user;
        this.date = date;
        this.ip = ip;
    }



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
}