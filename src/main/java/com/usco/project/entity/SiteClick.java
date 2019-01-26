package com.usco.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SiteClick {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(nullable=false)
    private Date date;

    @JoinColumn(nullable=false)
    @ManyToOne
    private User user;

    @JoinColumn(nullable=false)
    @ManyToOne
    private Site site;


    public SiteClick() {
    }


    public SiteClick(Date date, User user, Site site) {
        this.date = date;
        this.user = user;
        this.site = site;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Site getSite() {
        return this.site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

}