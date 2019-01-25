package com.usco.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Publicity {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private Date  startTime;

    @Column
    private Date endTime;

    @ManyToOne
    private Site site;

    @Column
    private int state;

    @Column
    private int priority;

    @Column
    private Date date_payment;



    public Publicity(Date start_time, Date end_time, Site site, int state, int priority, Date date_payment) {
        this.startTime = start_time;
        this.endTime = end_time;
        this.site = site;
        this.state = state;
        this.priority = priority;
        this.date_payment = date_payment;
    }

    public Publicity() {
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStarTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Site getSite() {
        return this.site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}