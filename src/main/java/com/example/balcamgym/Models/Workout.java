package com.example.balcamgym.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private long id;


    private String name;

    private String description;

    private LocalTime iniTime, endTime;

    private int capacity;

    private String location;


    public Workout(){}

    public Workout (String name, String description, LocalTime iniTime, LocalTime endTime, int capacity, String location) {
        this.name = name;
        this.description = description;
        this.iniTime = iniTime;
        this.endTime = endTime;
        this.capacity = capacity;
        this.location = location;
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




    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }



    public LocalTime getIniTime() {
        return iniTime;
    }
    public void setIniTime(LocalTime iniTime) {
        this.iniTime = iniTime;
    }



    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }



    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }



    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
