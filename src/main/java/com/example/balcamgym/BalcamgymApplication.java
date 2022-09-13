package com.example.balcamgym;


import com.example.balcamgym.MODELS.Account;
import com.example.balcamgym.MODELS.Client;
import com.example.balcamgym.REPOSITORIES.AccountRepositories;
import com.example.balcamgym.REPOSITORIES.ClientRepositories;
import com.example.balcamgym.REPOSITORIES.SubscriptionsRepositories;
import com.example.balcamgym.REPOSITORIES.WorkoutRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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


		clientRepositories.save(client1);

		accountRepositories.save(accountClient1);


	};
	}
}
