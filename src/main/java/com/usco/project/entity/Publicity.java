package com.usco.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Publicity {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(nullable=false)
    private Date  startTime;

    @Column(nullable=false)
    private Date endTime;

    @JoinColumn(nullable=false)
    @ManyToOne
    private Site site;

    @Column(nullable=false)
    private Integer state;

    @Column(nullable=false)
    private Integer priority;

    @Column(nullable=false)
    private Date datePayment;



    public Publicity(Date start_time, Date end_time, Site site, Integer state, Integer priority, Date datePayment) {
        this.startTime = start_time;
        this.endTime = end_time;
        this.site = site;
        this.state = state;
        this.priority = priority;
        this.datePayment = datePayment;
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

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }


    public Date getDatePayment() {
        return this.datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

}