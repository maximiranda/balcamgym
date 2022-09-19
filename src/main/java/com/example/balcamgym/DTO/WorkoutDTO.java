package com.example.balcamgym.DTO;

import com.example.balcamgym.Models.Client;

import java.time.LocalDate;
import java.time.LocalTime;

public class WorkoutDTO {

    private Client client;
    private String name;
    private String coachName;
    private String description;
    private LocalDate fromDate, toDate;
    private LocalTime fromTime, toTime;

    public WorkoutDTO(){}

    public WorkoutDTO(Client client, String name, String coachName, String description, LocalDate fromDate, LocalDate toDate, LocalTime fromTime, LocalTime toTime) {
        this.client = client;
        this.name = name;
        this.coachName = coachName;
        this.description = description;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public Client getClient() {return client;}

    public String getName() {return name;}

    public String getCoachName() {return coachName;}

    public String getDescription() {return description;}

    public LocalDate getFromDate() {return fromDate;}

    public LocalDate getToDate() {return toDate;}

    public LocalTime getFromTime() {return fromTime;}

    public LocalTime getToTime() {return toTime;}
}
