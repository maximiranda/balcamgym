package com.example.balcamgym;


import com.example.balcamgym.Models.*;
import com.example.balcamgym.Repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Set;

@SpringBootApplication
public class BalcamgymApplication {

	public static void main(String[] args) {
		SpringApplication.run(BalcamgymApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData (ClientRepositories clientRepositories, ProductStorageRepositories productStorageRepositories, ProductRepositories productRepositories, BillRepositories billRepositories,
									   BillSubscriptionRepositories billSubscriptionRepositories, SubscriptionRepositories subscriptionRepositories){
	return (args) -> {
			Client client = new Client("hola","hola","hola@hola","hola123",true);
			clientRepositories.save(client);

			Product p1 = new Product("pantalon",ProductCategory.CLOTHES,1000,10);
			Product p2 = new Product("panta",ProductCategory.CLOTHES,1000,10);
			Product p3 = new Product("pantis",ProductCategory.CLOTHES,1000,10);
			Product p4 = new Product("pantalones",ProductCategory.CLOTHES,1000,10);

			productRepositories.save(p1);
		productRepositories.save(p2);
		productRepositories.save(p3);
		productRepositories.save(p4);

		ProductStorage ps = new ProductStorage(Set.of(p1,p2,p3));
		productStorageRepositories.save(ps);

		Bill bill1 = new Bill(client,ps, p1.getName()+" "+p2.getName()+" "+p3.getName(), p1.getPrice()+ p2.getPrice()+ p3.getPrice());
		billRepositories.save(bill1);

		Subscription sub1 = new Subscription(SubscriptionTypes.BASIC,49,LocalDate.now(),LocalDate.now().plusMonths(1));
		subscriptionRepositories.save(sub1);

		BillSubscription bils1 = new BillSubscription(client,sub1, sub1.getAmount(),sub1.getFromdate(),sub1.getToDate());
		billSubscriptionRepositories.save(bils1);



	};
	}
}
