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

	public static void main(String[] args) {
		SpringApplication.run(BalcamgymApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData (ClientRepository clientRepository, ProductStorageRepository productStorageRepository, ProductRepository productRepository, BillRepository billRepository,
									   BillSubscriptionRepository billSubscriptionRepository, SubscriptionRepository subscriptionRepository, ImgFIleServices imgFIleServices){
	return (args) -> {
		imgFIleServices.deleteAll();
		imgFIleServices.init();
		Client Admin = new Client("Admin","Admin","admin@balcamgym.com",passwordEncoder.encode("balcamgym"),true);

		Client client = new Client("hola","hola","hola@hola",passwordEncoder.encode("hola123"),true);

		Product menClothes0 = new Product("Under Armour Men's" + "HeatGear Leggings","84% Polyester, 16% Elastane, Imported, Pull On closure, Machine Wash, Super-light" +
				"HeatGear fabric delivers superior coverage without weighing you down, Strategic" +
				"mesh panels for added ventilation where you need it, Material wicks sweat & dries" +
				"really fast","./assets/images/leggingsMens.png",ProductCategory.CLOTHES,24.49,25);

		Product menClothes1 = new Product("Cabeen Men's Workout Sport Tank Tops Gym ","Pull On closure, Hand Wash Only, Material: These mens tank tops are made of high" +
				"quality light weight and super soft fabric, not easy to deform or shrink. Y-Back Design:"
				,"./assets/images/tankTops.png",ProductCategory.CLOTHES,14.99,15);

		Product menClothes2 = new Product("Men's Tech 2.0 ShortSleeve T-Shirt","100% Polyester, Imported, UA Tech fabric is quick-drying, ultra-soft & has a more" +
				"natural feel, Material wicks sweat & dries really fast, New, streamlined fit & shaped" +
				"hem","./assets/images/tShirtMens.png",ProductCategory.CLOTHES,12.17,5);

		Product menClothes3 = new Product("Men's Elastic Shorts Pants","85% Polyester, 15% Spandex, Pull On closure, Machine Wash, High performance" +
				"elastic with excellent elasticity. Elastic fit for increased mobility and muscle support.","./assets/images/shortPants.png",ProductCategory.CLOTHES,25.99,10);

		Product menClothes4 = new Product("Under Armour Men’s Tech 2.0 ½ Zip Long Sleeve","100% Polyester, Zipper closure, Machine Wash, UA Tech fabric is quick-drying, ultrasoft & has a more natural feel, Material wicks sweat & dries really fast, Generous ½ zip" +
				"front makes for easy layering","./assets/images/mensLongSleeve.png",ProductCategory.CLOTHES,20.00,15);

		Product menClothes5 = new Product("Athletic Gym Training Slim Fit Jogger Jogging Long Track Pants Sweatpants","95% Polyester, 5% Spandex, Drawstring closure, Drawstring on elastic waistband can" +
				"ensure the fit and comfortable when you wearing this joggers Pants.","./assets/images/mensLongJogging.png",ProductCategory.CLOTHES,12.99,10);

		Product menClothes6 = new Product("Champion Authentic Originals Men's Sueded Fleece Jogger Sweatpants","80% Cotton, 20% Polyester, Imported, No Closure closure, Machine Wash, 8.5 oz." +
				"polyester fleece is high in cotton, high in comfort. Sueded fleece is sanded to make it" +
				"incredibly soft, inside and out.","./assets/images/joggerSweatpants.png",ProductCategory.CLOTHES,18.95,18);

		productRepository.save(menClothes0);
		productRepository.save(menClothes1);
		productRepository.save(menClothes2);
		productRepository.save(menClothes3);
		productRepository.save(menClothes4);
		productRepository.save(menClothes5);
		productRepository.save(menClothes6);

		Product womenClothes0 = new Product("Womens gym sets gradient seamless yoga","70% Cotton, 30% Polyester, Imported, No Closure closure, Machine Wash, 8.5 oz" +
				"Women Seamless Long Sleeve Yoga Set Gym Crop Top and High Waist Bra" +
				"Leggings.","./assets/images/womengymset1.webp",ProductCategory.CLOTHES,24.49,10);

		Product womenClothes1 = new Product("Ot-Ew Women's Seamless Sports Leggings","85% Polyester, 15% Spandex, Pull On closure. ideal to be comfortable while doing" +
				"sports. Color: blue","./assets/images/womengymsetunique.png",ProductCategory.CLOTHES,14.99,11);

		Product womenClothes2 = new Product("Womens gym one piece set with color black","100% Cotton, Imported, No Closure closure, Machine Wash, 8.5 oz. polyester fleece" +
				"is high in cotton, high in comfort. Sueded fleece is sanded to make it incredibly soft,"+
				"inside and out","./assets/images/women3.png",ProductCategory.CLOTHES,12.15,7);

		Product womenClothes3 = new Product("Womens gym sets gradient seamless","70% Cotton, 30% Polyester, Imported, No Closure closure, Machine Wash, 8.5 oz" +
				"Women Seamless Long Sleeve Yoga Set Gym Crop Top and High Waist Bra","./assets/images/womenequip.webp",ProductCategory.CLOTHES,25.99,4);

		Product womenClothes4 = new Product("Seamless women's shorts","seamless women's shorts, ideal for any sport extremely comfortable and soft to the" +
				"touch. Color: black","./assets/images/womenshort.png",ProductCategory.CLOTHES,20.00,5);

		Product womenClothes5 = new Product("Fresh antiperspirant women's t-shirt","85% Polyester, 15% Spandex, Pull On closure. ideal to be comfortable while doing" +
				"sports. Color: light blue","./assets/images/womertshirt.png",ProductCategory.CLOTHES,12.99,18);

		Product womenClothes6 = new Product("Leggins Women cotton dry","Tight-fitting leggings to keep everything in place, soft to the touch, cotton dry 70%\n" +
				"Cotton, 30% Polyester","./assets/images/leggingswomen.webp",ProductCategory.CLOTHES,18.95,10);

		Product womenClothes7 = new Product("Leggins Women cotton dry","Tight-fitting leggings, soft to the touch, cotton dry 80% Cotton, 20% Polyester color:" +
				"black","./assets/images/womenleggins.png",ProductCategory.CLOTHES,12.15,12);

		Product womenClothes8 = new Product("Comfortable and soft women's top","Become your own personal trainer with this ultra comfortable and stretchy top, with" +
				"small design windows for better breathing. cotton dry 80% Cotton, 20% Polyester" +
				"color: black","./assets/images/womentshirt.png",ProductCategory.CLOTHES,25.99,3);

		Product womenClothes9 = new Product("Leggins Women cotton dry","Tight-fitting leggings, soft to the touch, pull On closure. ideal to be comfortable while" +
				"doing sports. cotton dry 80% Cotton, 20% Polyester color: purple","./assets/images/womenlegginsviolet.webp",ProductCategory.CLOTHES,20.00,8);

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

		Product equipments0 = new Product("Champion Sports BEST Balls","Champion Sports Rhino Promax Slam Balls, Soft Shell with Non-Slip Grip - Medicine Wall Ball" +
				"for Slamming, Bouncing, Throwing - Exercise Ball Set for Weightlifting, TRX, Plyometrics, Cross" +
				"Training. 4 Kg","./assets/images/joggerSweatpants.png",ProductCategory.EQUIPMENT,44.00,8);

		Product equipments1 = new Product("BEST Resistance Bands Set","Resistance Bands Set, Professional Non-Latex Elastic Band For Upper & Lower Body Exercise," +
				"Strength Training without Weights, Physical Therapy, Pilates, Rehab, Yellow & Red & Green," +
				"Beginner","./assets/images/bansSet.png",ProductCategory.EQUIPMENT,19.88,5);

		Product equipments2 = new Product("EVOLUTION Exercise Ma","EVOLUTION Exercise Mat for Fitness, Yoga, Pilates, Stretching & Floor Exercises (48L x 20W x" +
				"1/2-Inch Thick)","./assets/images/evolucionPad.png",ProductCategory.EQUIPMENT,23.85,8);

		Product equipments3 = new Product("BEST Training Rope", "Basics Battle Exercise Training Rope - 30/40/50 Foot Lengths, 1.5/2 Inch Widths", "./assets/images/trainingRope.png",ProductCategory.EQUIPMENT,54.99,15);

		Product equipments4 = new Product("SPORT FITNESS Kettlebell","SPORT FITNESS Basics Cast Iron Kettlebell Weight. 12Kg","./assets/images/kettlebell.png",ProductCategory.EQUIPMENT,30.60,5);

		Product equipments5 = new Product("BARBELL Weight Plate","BalanceFrom Cast Iron Olympic 2-Inch Weight Plate","./assets/images/weightplate.png",ProductCategory.EQUIPMENT,169.99,4);

		Product equipments6 = new Product("THERABAND Resistance Tubes","THERABAND Resistance Tubes, Professional Latex Elastic Tubing with Soft Handles & Door" +
				"Anchor For Physical Therapy, Pilates, At-Home Workouts, and Rehab, 48 Inch, Silver, Super" +
				"Heavy, Advanced Level 2","./assets/images/resistanceTubes.png",ProductCategory.EQUIPMENT,19.99,10);

		Product equipments7 = new Product("BEST Hex Dumbbell","Rubber Encased Hex Dumbbell. 2Lb","./assets/images/hexDumbbell.png",ProductCategory.EQUIPMENT,43.70,8);

		Product equipments8 = new Product("CAPELLI Ab Wheel","Capelli Sport Ab Wheel Rollout, Exercise Roller for Abdominal and Core Strength Training Black","./assets/images/abWheel.png",ProductCategory.EQUIPMENT,14.99,12);

		Product equipments9 = new Product("BalanceFrom Aerobic Stepper", "BalanceFrom Adjustable Workout Aerobic Stepper Step Platform Trainer, 4 Removable Raisers Included","./assets/images/aerobicStepper.png",ProductCategory.EQUIPMENT,30.15,3);

		Product equipments10 = new Product("TRX GO TRX training","TRX GO Suspension Trainer and the Go Bundle - for the Travel Focused Professional or any Fitness Journey, TRX Training Club App ","./assets/images/trxTraining.png",ProductCategory.EQUIPMENT,219.50,2);

		productRepository.save(equipments0);
		productRepository.save(equipments1);
		productRepository.save(equipments2);
		productRepository.save(equipments3);
		productRepository.save(equipments4);
		productRepository.save(equipments5);
		productRepository.save(equipments6);
		productRepository.save(equipments7);
		productRepository.save(equipments8);
		productRepository.save(equipments9);
		productRepository.save(equipments10);

		
		Product suplementsBcaa0 = new Product("BCAA Capsules, Keto Friendly Branched Chain Essential Amino Acids","ENA Instantized BCAA Capsules, Keto Friendly Branched Chain Essential Amino" +
				"Acids, 1800mg,120 caps","./assets/images/bcaaENA.png",ProductCategory.SUPPLEMENTS,20.59,10);

		Product suplementsBcaa1 = new Product("GAT Sport Essentials Men Multi Plus","GAT Sport Essentials Men Multi Plus Test Capsules, 180 Count","./assets/images/bcaaGAT.png",ProductCategory.SUPPLEMENTS,23.99,4);

		Product suplementsBcaa2 = new Product("Optimum Nutrition Instantized BCAA Powder","Optimum Nutrition Instantized BCAA Powder, Unflavored, Keto Friendly Branched Chain" +
				"Essential Amino Acids Powder, 5000mg, 60 Servings (Packaging May Vary)","./assets/images/bcaaON.png",ProductCategory.SUPPLEMENTS,26.80,8);

		Product suplementsBcaa3 = new Product("Star BCAA 2000 Amino Energy Plus","Star BCAA 2000 Amino Energy Plus Electrolytes Energy Drink Powder, Caffeine" +
				"for Pre-Workout Energy, Amino Acids / BCAAs for Post-Workout Recovery","./assets/images/bcaaSTAR.png",ProductCategory.SUPPLEMENTS,19.88,2);

		Product suplementsBcaa4 = new Product("Ultra Tech BCAA Sport, BCAA Powder Sports","BCAA Sport is NSF-certified and contains a 2: 1: 1 ratio of BCAAs and Amino Acids" +
				"to replenish energy, protein","./assets/images/bcaaULTRATECH.png",ProductCategory.SUPPLEMENTS,30.88,8);

		productRepository.save(suplementsBcaa0);
		productRepository.save(suplementsBcaa1);
		productRepository.save(suplementsBcaa2);
		productRepository.save(suplementsBcaa3);
		productRepository.save(suplementsBcaa4);

		Product suplementsCreatine0 = new Product("Creatine ENA Monohydrate Powder", "Optimum Nutrition Micronized Creatine ENA Monohydrate Powder, Unflavored, Keto" +
				"Friendly, 120 Servings (Packaging May Vary) ", "./assets/images/creatineENA.png",ProductCategory.SUPPLEMENTS,18.35,8);

		Product suplementsCreatine1 = new Product("GAT Sport JetMass","GAT Sport JetMass Fact-Acting Volumizing Creatine System, 30 Servings (Tropical Ice)","./assets/images/creatineGAT.png",ProductCategory.SUPPLEMENTS,36.15,2);

		Product suplementsCreatine2 = new Product("Optimus Nutrition Creatine Powder","5 grams pure creatine monohydrate per serving · Supports increases in energy, endurance and recovery · Maximum potency supports muscle size, strength, and power","./assets/images/creatineON.png",ProductCategory.SUPPLEMENTS,32.00,8);

		Product suplementsCreatine3 = new Product("Star Nutrition Creatine Monohydrate","CREATINE MONOHYDRATE. Suplemento dietario a base de Creatina Monohidrato. 300G | 60 SERV. | 5G CREATINA X SERV. | ULTRAMICRONIZED","./assets/images/creatineSTAR.png",ProductCategory.SUPPLEMENTS,44.99,9);

		Product suplementsCreatine4 = new Product("Ultra Tech Creatine","Creatine collaborates with the increase of energy and maintenance of ATP levels (the cellular energy reserve), during the contraction of the muscles.","./assets/images/creatineULTRATECH.png",ProductCategory.SUPPLEMENTS,16.99,8);

		productRepository.save(suplementsCreatine0);
		productRepository.save(suplementsCreatine1);
		productRepository.save(suplementsCreatine2);
		productRepository.save(suplementsCreatine3);
		productRepository.save(suplementsCreatine4);

		Product suplementsProtein0 = new Product("Whey protein ENA True Made","Optimum NutritionTrue Made 100% Whey Protein Powder, Extreme Milk Chocolate, 5 Pound" +
				"(Packaging May Vary)","./assets/images/wheyproteinENA.png",ProductCategory.SUPPLEMENTS,27.35,8);

		Product suplementsProtein1 = new Product("BSN SYNTHA-6 Whey Vanilla Protein","BSN SYNTHA-6 Whey Protein Powder, Vanilla Protein Powder with Micellar Casein, Milk" +
				"Protein Isolate Powder, Vanilla Ice Cream, 48 Servings (Packaging May Vary","./assets/images/wheyproteinSYNTHA-6.png",ProductCategory.SUPPLEMENTS,48.25,2);

		Product suplementsProtein2 = new Product("Optimum Nutrition Gold Standard 100%","Optimum Nutrition Gold Standard 100% Whey Protein Powder, Naturally Flavored Chocolate," +
				"4.8 Pound (Packaging May Vary) ","./assets/images/wheyproteinON.png",ProductCategory.SUPPLEMENTS,26.45,7);

		Product suplementsProtein3 = new Product("Platinum Star Whey Protein","Dietary powder dietary supplement to prepare drink based on whey proteins." +
				"2 POUNDS | 30 SERV. | 25GR OF PROTEIN X SERV","./assets/images/wheyproteinSTAR.png",ProductCategory.SUPPLEMENTS,28.59,8);

		Product suplementsProtein4 = new Product("Whey Protein Burner ULTRATECH","Whey Protein Burner X 907 G Supplement 2 in 1 Muscle Mass and Fat Burning Contains Ultra Tech Whey Protein.","./assets/images/wheyproteinULTRATECH.png",ProductCategory.SUPPLEMENTS,30.00,16);

		Product suplementsProtein5 = new Product("Whey Protein GAT isolate blend","GAT Sport's Whey Protein Powder makes smooth delicious protein shakes which are packed with 25 grams of fast acting whey protein to help you increase strength, and put on lean muscle mass.","./assets/images/wheyproteinGAT.png",ProductCategory.SUPPLEMENTS,39.99,4);

		productRepository.save(suplementsProtein0);
		productRepository.save(suplementsProtein1);
		productRepository.save(suplementsProtein2);
		productRepository.save(suplementsProtein3);
		productRepository.save(suplementsProtein4);
		productRepository.save(suplementsProtein5);


		Subscription sub1 = new Subscription(SubscriptionTypes.BASIC,49,LocalDate.now(),LocalDate.now().plusMonths(1));

		BillSubscription bils1 = new BillSubscription(client,sub1, sub1.getAmount(),sub1.getFromdate(),sub1.getToDate());

		clientRepository.save(Admin);
		clientRepository.save(client);



		subscriptionRepository.save(sub1);
		billSubscriptionRepository.save(bils1);


	};
	}
	@Autowired
	private PasswordEncoder passwordEncoder;

}
