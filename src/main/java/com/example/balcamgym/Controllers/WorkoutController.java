package com.example.balcamgym.Controllers;

import com.example.balcamgym.DTO.WorkoutDTO;
import com.example.balcamgym.Models.Client;
import com.example.balcamgym.Models.SubscriptionTypes;
import com.example.balcamgym.Models.Workout;
import com.example.balcamgym.Services.ClientServices;
import com.example.balcamgym.Services.WorkoutServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class WorkoutController {

    @Autowired
    private WorkoutServices workoutServices;
    @Autowired
    private ClientServices clientServices;

    @GetMapping("/workouts")
    public List<WorkoutDTO> getWorkouts(){
        return workoutServices.getWorkouts().stream().map(WorkoutDTO::new).collect(Collectors.toList());
    }

    @Transactional
    @PostMapping("/workouts")
    public ResponseEntity<Object> addWorkout(Authentication authentication,@RequestParam List<Long> ids){
        Client client = clientServices.findByEmail(authentication.getName());
        if (client == null){
            return new ResponseEntity<>("", HttpStatus.FORBIDDEN);

        }
        for (Long id: ids){
            if (client.getWorkouts().size() >= 1 && client.getBillSubscription().getSubscription().getSubscriptionTypes() == SubscriptionTypes.BASIC ){
                return new ResponseEntity<>("m", HttpStatus.FORBIDDEN);
            }
            if (client.getWorkouts().size() >= 3 && client.getBillSubscription().getSubscription().getSubscriptionTypes() == SubscriptionTypes.STANDAR ){
                return new ResponseEntity<>("a", HttpStatus.FORBIDDEN);
            }
            Workout workout = workoutServices.getWorkoutById(id);
            client.addWorkouts(workout);
            workout.addClients(client);
            workoutServices.saveWorkout(workout);
            clientServices.saveClient(client);
        }
        return new ResponseEntity<>("inscribed", HttpStatus.CREATED);
    }
}
