package com.usco.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity()
public class SiteTrasing {

    @Id
    @GeneratedValue
    @Column(unique=true)
    private Long id;

    @Column(nullable=false)
    private Long siteId;

    @ManyToOne
    @JoinColumn(nullable=false)
    private User user;

    @Column(nullable=false)
    private String action;

    @Column(nullable=false)
    private Date date;

    @Column(nullable=false)
    private String ip;

    public SiteTrasing() {

    }


    public SiteTrasing(Long siteId, User user, String action, Date date, String ip) {
        this.siteId = siteId;
        this.user = user;
        this.action = action;
        this.date = date;
        this.ip = ip;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSiteId() {
        return this.siteId;
    }

    public void setSite(Long siteId) {
        this.siteId = siteId;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
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