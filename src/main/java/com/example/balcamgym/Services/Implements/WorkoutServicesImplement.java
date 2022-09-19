package com.example.balcamgym.Services.Implements;

import com.example.balcamgym.DTO.WorkoutDTO;
import com.example.balcamgym.Models.Workout;
import com.example.balcamgym.Repositories.WorkoutRepository;
import com.example.balcamgym.Services.WorkoutServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class WorkoutServicesImplement implements WorkoutServices {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Override
    public List<Workout> getWorkouts() {
        return workoutRepository.findAll();
    }
    @Override
    public Workout getWorkoutById(Long id){
        return workoutRepository.findById(id).get();
    }
    @Override
    public  void saveWorkout(Workout workout){
        workoutRepository.save(workout);
    }
}
