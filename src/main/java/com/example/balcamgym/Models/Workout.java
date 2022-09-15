package com.example.balcamgym.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;


    private String name;

    private String coachName;

    private String description;

    private LocalDate fromDate, toDate;

    private LocalTime fromTime, toTime;


    public Workout(){}

    public Workout(String name,String coachName, String description, LocalDate fromDate, LocalDate toDate, LocalTime fromTime, LocalTime toTime) {
        this.name = name;
        this.coachName = coachName;
        this.description = description;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public Workout(Client client, String name, String coachName, String description, LocalDate fromDate, LocalDate toDate, LocalTime fromTime, LocalTime toTime) {
        this.client = client;
        this.name = name;
        this.coachName = coachName;
        this.description = description;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getCoachName() {
        return coachName;
    }
    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }



    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }



    public LocalDate getFromDate() {
        return fromDate;
    }
    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }



    public LocalDate getToDate() {
        return toDate;
    }
    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }



    public LocalTime getFromTime() {
        return fromTime;
    }
    public void setFromTime(LocalTime fromTime) {
        this.fromTime = fromTime;
    }



    public LocalTime getToTime() {
        return toTime;
    }
    public void setToTime(LocalTime toTime) {
        this.toTime = toTime;
    }



    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
}
