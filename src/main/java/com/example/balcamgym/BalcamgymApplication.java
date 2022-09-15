package com.example.balcamgym;


import com.example.balcamgym.Models.*;
import com.example.balcamgym.Repositories.*;
import com.example.balcamgym.Services.ImgFIleServices;
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
	public CommandLineRunner initData (ClientRepository clientRepository, ProductStorageRepository productStorageRepository, ProductRepository productRepository, BillRepository billRepository,
									   BillSubscriptionRepository billSubscriptionRepository, SubscriptionRepository subscriptionRepository, ImgFIleServices imgFIleServices){
	return (args) -> {
		imgFIleServices.deleteAll();
		imgFIleServices.init();
		Client Admin = new Client("Admin","Admin","admin@balcamgym.com","balcamgym",false);

		Client client = new Client("hola","hola","hola@hola","hola123",true);

		Product p1 = new Product("pantalon",ProductCategory.CLOTHES,1000,10);
		Product p2 = new Product("panta",ProductCategory.CLOTHES,1000,10);
		Product p3 = new Product("pantis",ProductCategory.CLOTHES,1000,10);
		Product p4 = new Product("pantalones",ProductCategory.CLOTHES,1000,10);




		double amount = 0.0;
		Bill bill1 = new Bill(client, amount);
		ProductStorage ps = new ProductStorage(p3	, bill1);
		bill1.setProductStorage(ps);

		Subscription sub1 = new Subscription(SubscriptionTypes.BASIC,49,LocalDate.now(),LocalDate.now().plusMonths(1));

		BillSubscription bils1 = new BillSubscription(client,sub1, sub1.getAmount(),sub1.getFromdate(),sub1.getToDate());

		clientRepository.save(Admin);
		clientRepository.save(client);
		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p4);
		billRepository.save(bill1);
		productStorageRepository.save(ps);
		subscriptionRepository.save(sub1);
		billSubscriptionRepository.save(bils1);


	};
	}
}
