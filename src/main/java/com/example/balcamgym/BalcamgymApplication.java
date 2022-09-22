package com.example.balcamgym;

import com.example.balcamgym.Models.*;
import com.example.balcamgym.Repositories.*;
import com.example.balcamgym.Services.ImgFIleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class BalcamgymApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(BalcamgymApplication.class, args);
	}


	@Bean
	public CommandLineRunner initData (ClientRepository clientRepository, ProductStorageRepository productStorageRepository, ProductRepository productRepository, WorkoutRepository workoutRepository, BillRepository billRepository,
									   BillSubscriptionRepository billSubscriptionRepository, SubscriptionRepository subscriptionRepository, ImgFIleServices imgFIleServices){
	return (args) -> {

		imgFIleServices.init();
		Client Admin = new Client("Admin","Admin","admin@balcamgym.com",passwordEncoder.encode("balcamgym"),true);

		Client client = new Client("hola","hola","hola@hola",passwordEncoder.encode("hola123"),true);

		Product menClothes0 = new Product("Under Armour Men Leggings","84% Polyester, 16% Elastane, Imported, Pull On closure, Machine Wash, Super-light" +
				"HeatGear fabric delivers superior coverage without weighing you down, Strategic" +
				"mesh panels for added ventilation where you need it, Material wicks sweat & dries" +
				"really fast","/web/assets/images/products/1.png",ProductCategory.CLOTHES,24.49,25,true);

		Product menClothes1 = new Product("Tank T-shirt Gym Men's Workout Sport","Pull On closure, Hand Wash Only, Material: These mens tank tops are made of high" +
				"quality light weight and super soft fabric, not easy to deform or shrink. Y-Back Design:"
				,"/web/assets/images/products/2.webp",ProductCategory.CLOTHES,14.99,15,true);

		Product menClothes2 = new Product("Men's Tech 2.0 ShortSleeve Epic T-Shirt","100% Polyester, Imported, UA Tech fabric is quick-drying, ultra-soft & has a more" +
				"natural feel, Material wicks sweat & dries really fast, New, streamlined fit & shaped" +
				"hem","/web/assets/images/products/3.png",ProductCategory.CLOTHES,12.17,5,true);

		Product menClothes3 = new Product("Men's Elastic Shorts Pants black","85% Polyester, 15% Spandex, Pull On closure, Machine Wash, High performance" +
				"elastic with excellent elasticity. Elastic fit for increased mobility and muscle support.","/web/assets/images/products/4.png",ProductCategory.CLOTHES,25.99,10,true);

		Product menClothes4 = new Product("Black Men Shorts Joggers","100% Polyester, Zipper closure, Machine Wash, UA Tech fabric is quick-drying, ultrasoft & has a more natural feel, Material wicks sweat & dries really fast, Generous ½ zip" +
				"front makes for easy layering","/web/assets/images/products/5.jpg",ProductCategory.CLOTHES,20.00,15,true);

		Product menClothes5 = new Product("Athletic Gym Training Slim Fit Jogger Jogging Long Track Pants Sweatpants","95% Polyester, 5% Spandex, Drawstring closure, Drawstring on elastic waistband can" +
				"ensure the fit and comfortable when you wearing this joggers Pants.","/web/assets/images/products/6.png",ProductCategory.CLOTHES,12.99,10,true);

		Product menClothes6 = new Product("Originals Men's Sueded Fleece Jogger Sweatpants","80% Cotton, 20% Polyester, Imported, No Closure closure, Machine Wash, 8.5 oz." +
				"polyester fleece is high in cotton, high in comfort. Sueded fleece is sanded to make it" +
				"incredibly soft, inside and out.","/web/assets/images/products/7.webp",ProductCategory.CLOTHES,18.95,18,true);

		Product menClothes7 = new Product("Originals man set Fleece Dry black","60% Cotton, 40% Polyester, Imported, No Closure closure, Machine Wash, 8.5 oz." +
				"polyester fleece is high in cotton, high in comfort. Sueded fleece is sanded to make it" +
				"incredibly soft, inside and out.","/web/assets/images/products/0.webp",ProductCategory.CLOTHES,18.95,18,true);

		productRepository.save(menClothes0);
		productRepository.save(menClothes1);
		productRepository.save(menClothes2);
		productRepository.save(menClothes3);
		productRepository.save(menClothes4);
		productRepository.save(menClothes5);
		productRepository.save(menClothes6);
		productRepository.save(menClothes7);

		Product womenClothes0 = new Product("Womens gym sets gradient seamless yoga","70% Cotton, 30% Polyester, Imported, No Closure closure, Machine Wash, 8.5 oz" +
				"Women Seamless Long Sleeve Yoga Set Gym Crop Top and High Waist Bra" +
				"Leggings.","/web/assets/images/products/8.png",ProductCategory.CLOTHES,24.49,10,true);

		Product womenClothes1 = new Product("Ot-Ew Women's Seamless Sports Leggings","85% Polyester, 15% Spandex, Pull On closure. ideal to be comfortable while doing" +
				"sports. Color: blue","/web/assets/images/products/9.jpg",ProductCategory.CLOTHES,14.99,11,true);

		Product womenClothes2 = new Product("Womens gym top black top one fresh","100% Cotton, Imported, No Closure closure, Machine Wash, 8.5 oz. polyester fleece" +
				"is high in cotton, high in comfort. Sueded fleece is sanded to make it incredibly soft,"+
				"inside and out","/web/assets/images/products/10.png",ProductCategory.CLOTHES,12.15,7,true);

		Product womenClothes3 = new Product("Womens gym sets gradient seamless pink","70% Cotton, 30% Polyester, Imported, No Closure closure, Machine Wash, 8.5 oz" +
				"Women Seamless Long Sleeve Yoga Set Gym Crop Top and High Waist Bra","/web/assets/images/products/11.webp",ProductCategory.CLOTHES,25.99,4,true);

		Product womenClothes4 = new Product("Seamless women's shorts black","seamless women's shorts, ideal for any sport extremely comfortable and soft to the" +
				"touch. Color: black","/web/assets/images/products/12.png",ProductCategory.CLOTHES,20.00,5,true);

		Product womenClothes5 = new Product("Fresh antiperspirant women's t-shirt","85% Polyester, 15% Spandex, Pull On closure. ideal to be comfortable while doing" +
				"sports. Color: light blue","/web/assets/images/products/13.jpg",ProductCategory.CLOTHES,12.99,18,true);

		Product womenClothes6 = new Product("Leggins Women cotton dry ultra fresh","Tight-fitting leggings to keep everything in place, soft to the touch, cotton dry 70%\n" +
				"Cotton, 30% Polyester","/web/assets/images/products/14.png",ProductCategory.CLOTHES,18.95,10,true);

		Product womenClothes7 = new Product("Three-quarter Leggins Women cotton dry ","Tight-fitting leggings, soft to the touch, cotton dry 80% Cotton, 20% Polyester color:" +
				"black","/web/assets/images/products/15.webp",ProductCategory.CLOTHES,12.15,12,true);

		Product womenClothes8 = new Product("Comfortable and soft women's top","Become your own personal trainer with this ultra comfortable and stretchy top, with" +
				"small design windows for better breathing. cotton dry 80% Cotton, 20% Polyester" +
				"color: black","/web/assets/images/products/16.png",ProductCategory.CLOTHES,25.99,3,true);

		Product womenClothes9 = new Product("Leggins Women cotton dry with batman print","Tight-fitting leggings, soft to the touch, pull On closure. ideal to be comfortable while" +
				"doing sports. cotton dry 80% Cotton, 20% Polyester","/web/assets/images/products/17.png",ProductCategory.CLOTHES,20.00,8,true);

		productRepository.save(womenClothes0);
		productRepository.save(womenClothes1);
		productRepository.save(womenClothes2);
		productRepository.save(womenClothes3);
		productRepository.save(womenClothes4);
		productRepository.save(womenClothes5);
		productRepository.save(womenClothes6);
		productRepository.save(womenClothes7);
		productRepository.save(womenClothes8);
		productRepository.save(womenClothes9);

		Product equipments0 = new Product("Elastic bands for bodybuilding and resistance","ultra-resistant bands for gym, 100% waterproof," +
				"Strength Training without Weights, Physical Therapy, Pilates, Rehab, Yellow & Red & Green & Blue & Black," +
				"Beginner","/web/assets/images/products/18.png",ProductCategory.EQUIPMENT,19.88,5,true);

		Product equipments1 = new Product("BEST Resistance Yoga Mat","ultra-resistant mat for yoga and stretching, 100% waterproof," +
				"Strength Training without Weights, Physical Therapy, Pilates, Rehab, Yellow & Red & Green," +
				"Beginner","/web/assets/images/products/19.png",ProductCategory.EQUIPMENT,19.88,5,true);

		Product equipments2 = new Product("EVOLUTION Exercise Ma","EVOLUTION Exercise Mat for Fitness, Yoga, Pilates, Stretching & Floor Exercises (48L x 20W x" +
				"1/2-Inch Thick)","/web/assets/images/products/20.png",ProductCategory.EQUIPMENT,23.85,8,true);

		Product equipments4 = new Product("SPORT FITNESS Kettlebell","SPORT FITNESS Basics Cast Iron Kettlebell Weight. 12Kg","/web/assets/images/products/21.png",ProductCategory.EQUIPMENT,30.60,5,true);

		Product equipments5 = new Product("BARBELL Weight Plate","BalanceFrom Cast Iron Olympic 2-Inch Weight Plate","/web/assets/images/products/22.png",ProductCategory.EQUIPMENT,169.99,4,true);

		Product equipments6 = new Product("THERABAND Resistance Tubes","THERABAND Resistance Tubes, Professional Latex Elastic Tubing with Soft Handles & Door" +
				"Anchor For Physical Therapy, Pilates, At-Home Workouts, and Rehab, 48 Inch, Silver, Super" +
				"Heavy, Advanced Level 2","/web/assets/images/products/23.png",ProductCategory.EQUIPMENT,19.99,10,true);

		Product equipments7 = new Product("BEST Hex Dumbbell","Rubber Encased Hex Dumbbell. 2Lb","/web/assets/images/products/24.jpg",ProductCategory.EQUIPMENT,43.70,8,true);

		Product equipments8 = new Product("CAPELLI Ab Wheel","Capelli Sport Ab Wheel Rollout, Exercise Roller for Abdominal and Core Strength Training Black","/web/assets/images/products/25.png",ProductCategory.EQUIPMENT,14.99,12,true);

		Product equipments9 = new Product("BalanceFrom Aerobic Stepper", "BalanceFrom Adjustable Workout Aerobic Stepper Step Platform Trainer, 4 Removable Raisers Included","/web/assets/images/products/26.png",ProductCategory.EQUIPMENT,30.15,3,true);

		Product equipments10 = new Product("TRX GO TRX training","TRX GO Suspension Trainer and the Go Bundle - for the Travel Focused Professional or any Fitness Journey, TRX Training Club App ","/web/assets/images/products/27.png",ProductCategory.EQUIPMENT,219.50,2,true);

		productRepository.save(equipments0);
		productRepository.save(equipments1);
		productRepository.save(equipments2);
		productRepository.save(equipments4);
		productRepository.save(equipments5);
		productRepository.save(equipments6);
		productRepository.save(equipments7);
		productRepository.save(equipments8);
		productRepository.save(equipments9);
		productRepository.save(equipments10);

		Product sumplement0 = new Product("BCAA ENA","It is an excellent recuperator and also improves muscle growth. Provides metabolic energy to muscles and decreases protein breakdown during intense exercise" ,"/web/assets/images/products/bcaaENA.png",ProductCategory.SUPPLEMENTS,12.52,30,true);
		Product sumplement1 = new Product("BCAA GAT","This new formula boasts Nitrosigine as its only source of Arginine. Nitrosigine has been shown to inhibit the enzyme responsible for breaking down Arginine, making it the superior choice of arginine supplementation and a perfect synergistic partner to L-Citrulline." ,"/web/assets/images/products/bcaaGAT.png",ProductCategory.SUPPLEMENTS,10.20,25,true);
		Product sumplement2 = new Product("BCAA ON","The BCAA 2:1:1 ratio of leucine, isoleucine, valine\n RECOVERY takes your training efforts to the next level by supporting endurance and recovery" ,"/web/assets/images/products/bcaaON.png",ProductCategory.SUPPLEMENTS,17.20,20,true);
		Product sumplement3 = new Product("Creatine ENA","Our Micronized Creatine is an excellent pre-workout supplement as it collaborates in the formation of energy components, improves muscle power and delays muscle fatigue." ,"/web/assets/images/products/creatineENA.png",ProductCategory.SUPPLEMENTS,8.20,15,true);
		Product sumplement4 = new Product("Creatine GAT","Dymatize Creatine Monohydrate has always been processed to an extra-fine 180 microns, ensuring proper dispersion." ,"/web/assets/images/products/creatineGAT.png",ProductCategory.SUPPLEMENTS,8.20,10,true);
		Product sumplement5 = new Product("Creatine ON","Creatine Monohydrate is a naturally occurring substance found in the body and in foods such as meat and fish. Creatine is used by the body to produce energy for short bursts of high-intensity activity." ,"/web/assets/images/products/creatineON.png",ProductCategory.SUPPLEMENTS,9.80,8,true);
		Product sumplement6 = new Product("Whey Protein ENA","This type of supplement helps to complement the diet of people with specific nutritional goals or requirements. Its consumption can be indicated by various factors, such as the duration and intensity of the activity" ,"/web/assets/images/products/wheyproteinENA.png",ProductCategory.SUPPLEMENTS,18.20,10,true);
		Product sumplement7 = new Product("Whey Protein GAT","GAT Sport 100% Whey Protein is a premium quality whey protein powder that is ideal for athletes and bodybuilders who are looking to build muscle and increase strength." ,"/web/assets/images/products/wheyproteinGAT.png",ProductCategory.SUPPLEMENTS,20.50,15,true);
		Product sumplement8 = new Product("Whey Protein ON","Whey protein is a complete protein, meaning it contains all the essential amino acids needed to build and repair muscle tissue." ,"/web/assets/images/products/wheyproteinON.png",ProductCategory.SUPPLEMENTS,19.20,20,true);
		Product sumplement9 = new Product("Whey Protein Isolate STAR","Whey protein isolate is a type of protein supplement that is made from whey, a by-product of cheese production. Whey protein isolate is a concentrated form of whey protein that contains a higher percentage of protein than other types of whey protein." ,"/web/assets/images/products/wheyproteinSTAR.png",ProductCategory.SUPPLEMENTS,25.20,10,true);
		Product sumplement10 = new Product("Whey Protein SYNTHA-6","Whey protein isolate is a type of protein supplement that is made from whey, a by-product of cheese production. Whey protein isolate is a concentrated form of whey protein that contains a higher percentage of protein than other types of whey protein." ,"/web/assets/images/products/wheyproteinSYNTHA-6.png",ProductCategory.SUPPLEMENTS,30.00,10,true);

		productRepository.save(sumplement0);
		productRepository.save(sumplement1);
		productRepository.save(sumplement2);
		productRepository.save(sumplement3);
		productRepository.save(sumplement4);
		productRepository.save(sumplement5);
		productRepository.save(sumplement6);
		productRepository.save(sumplement7);
		productRepository.save(sumplement8);
		productRepository.save(sumplement9);
		productRepository.save(sumplement10);


		Workout lesson0 = new Workout("Body Building","Michael Logan","Bodybuilding is the use of progressive resistance exercise to control and develop one's muscles (muscle building) by muscle hypertrophy for aesthetic purposes","Monday","9:00 AM");

		Workout lesson1 = new Workout("Yoga","Lisa Douglas"," Yoga is an ancient practice that involves physical poses, concentration, and deep breathing. A regular yoga practice can promote endurance, strength, calmness, flexibility, and well-being.","Tuesday","10:00 AM");

		Workout lesson2 = new Workout("Body Building","Michael Logan","Bodybuilding is the use of progressive resistance exercise to control and develop one's muscles (muscle building) by muscle hypertrophy for aesthetic purposes","Tuesday","12:00 AM");

		Workout lesson3 = new Workout("Spinning","Sarah Lennox","Indoor cycling, often called spinning, is a form of exercise with classes focusing on endurance, strength, intervals, high intensity (race days) and recovery, and involves using a special stationary exercise bicycle with a weighted flywheel in a classroom setting","Wednesday","9:30 AM");

		Workout lesson4 = new Workout("Kick-boxing","David Robinson","Kickboxing is a group of stand-up combat sports and a form of boxing based on kicking and punching. The combat takes place in a boxing ring, normally with boxing gloves, mouthguards, shorts, and bare feet to favor the use of kicks. Kickboxing is practiced for self-defense, general fitness, or for competition.","Thursday","11:00 AM");

		Workout lesson5 = new Workout("Crossfit","Sarah Lennox","A form of high intensity interval training, CrossFit is a strength and conditioning workout that is made up of functional movement performed at a high intensity level. These movements are actions that you perform in your day-to-day life, like squatting, pulling, pushing etc","Friday","9:00 AM");

		workoutRepository.save(lesson0);
		workoutRepository.save(lesson1);
		workoutRepository.save(lesson2);
		workoutRepository.save(lesson3);
		workoutRepository.save(lesson4);
		workoutRepository.save(lesson5);


		Subscription sub1 = new Subscription(SubscriptionTypes.BASIC,49,LocalDate.now(),LocalDate.now().plusMonths(1));

		BillSubscription bils1 = new BillSubscription(client,sub1);

		clientRepository.save(Admin);
		clientRepository.save(client);



		subscriptionRepository.save(sub1);
		billSubscriptionRepository.save(bils1);


	};
	}


}
