package com.example.balcamgym.DTO;

import com.example.balcamgym.Models.Client;
import com.example.balcamgym.Models.Workout;

import java.time.LocalDate;
import java.time.LocalTime;

public class WorkoutDTO {

    private Long id;
    private String coachName, name, description, fromDate, fromTime;


    public WorkoutDTO(Workout workout) {
        this.id = workout.getId();
        this.name = workout.getName();
        this.coachName = workout.getCoachName();
        this.description = workout.getDescription();
        this.fromDate = workout.getFromDate();
        this.fromTime = workout.getFromTime();

    }

    public Long getId() {
        return id;
    }

    public String getCoachName() {
        return coachName;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getFromTime() {
        return fromTime;
    }
}
