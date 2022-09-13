package com.example.balcamgym.MODELS;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subscription_id")
    private Subscriptions subscriptions;

    private WorkoutTypes workoutTypes;


    public Workout (){}

    public Workout(Subscriptions subscriptions, WorkoutTypes workoutTypes) {
        this.subscriptions = subscriptions;
        this.workoutTypes = workoutTypes;
    }

    public long getId() {
        return id;
    }

    public Subscriptions getSubscriptions() {
        return subscriptions;
    }
    public void setSubscriptions(Subscriptions subscriptions) {
        this.subscriptions = subscriptions;
    }



    public WorkoutTypes getWorkoutTypes() {
        return workoutTypes;
    }
    public void setWorkoutTypes(WorkoutTypes workoutTypes) {
        this.workoutTypes = workoutTypes;
    }
}
