package com.example.balcamgym.Services;

import com.example.balcamgym.DTO.WorkoutDTO;
import com.example.balcamgym.Models.Workout;

import java.util.List;

public interface WorkoutServices {
    public List<Workout> getWorkouts();
    public Workout getWorkoutById(Long id);
    public void saveWorkout(Workout workout);
}
