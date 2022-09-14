package com.example.balcamgym;


import com.example.balcamgym.Models.*;
import com.example.balcamgym.Repositories.AccountRepositories;
import com.example.balcamgym.Repositories.ClientRepositories;
import com.example.balcamgym.Repositories.SubscriptionsRepositories;
import com.example.balcamgym.Repositories.WorkoutRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class BalcamgymApplication {

	public static void main(String[] args) {
		SpringApplication.run(BalcamgymApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData (ClientRepositories clientRepositories, AccountRepositories accountRepositories, SubscriptionsRepositories subscriptionsRepositories, WorkoutRepositories workoutRepositories){
	return (args) -> {
		Client client1 = new Client("Arnold","Suaseneger","arnold@arnold","arnolpapucho",20398123);
		Account accountClient1 = new Account("BAL-001",client1);
		Subscription firstSub = new Subscription(SubscriptionTypes.PREMIUM,1000, LocalDate.now(),LocalDate.now().plusMonths(1),accountClient1);



		clientRepositories.save(client1);

		accountRepositories.save(accountClient1);

		subscriptionsRepositories.save(firstSub);



	};
	}
}
