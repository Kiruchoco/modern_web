package com.example.cardatabase;

import com.example.cardatabase.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	@Autowired
	private CarRepository repository;

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application started");
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("John","Johnson");
		Owner owner2 = new Owner("Mary","Robinson");
		ownerRepository.saveAll(Arrays.asList(owner1,owner2));

		repository.save(new Car("Ford","Mustang","Red","ADF-1121",2021,59000,owner1));
		repository.save(new Car("Nissan","Leaf","White","SSJ-3002",2019,29000,owner2));
		repository.save(new Car("Toyota","Prius","Silver","KKO-0212",2020,39000,owner2));

		// 모든 자동차를 가져와 콘솔에 로깅
		for (Car car : repository.findAll()){
			logger.info(car.getBrand()+" "+car.getModel());
		}

		userRepository.save(new User("user",
				"$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));
		userRepository.save(new User("admin",
				"$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
	}
}
