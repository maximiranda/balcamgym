package com.example.balcamgym.Repositories;


import com.example.balcamgym.Models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface WorkoutRepository extends JpaRepository<Workout,Long> {
}
