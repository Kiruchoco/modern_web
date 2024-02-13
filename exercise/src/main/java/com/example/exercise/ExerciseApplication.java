package com.example.exercise;

import com.example.exercise.domain.Car;
import com.example.exercise.domain.CarRepository;
import com.example.exercise.domain.Owner;
import com.example.exercise.domain.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ExerciseApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(SpringApplication.class);

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private OwnerRepository ownerRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExerciseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 소유자 객체를 추가하고 데이터베이스에 저장
		Owner owner1 = new Owner("John","Johnson");
		Owner owner2 = new Owner("Mary","Robinson");
		ownerRepository.saveAll(Arrays.asList(owner1,owner2));

		Car car1 = new Car("Ford","Mustang","Red","ADF-1121",2021,59000,owner1);
		Car car2 = new Car("Nissan","Leaf","White","SSJ-3002",2019,29000,owner2);
		Car car3 = new Car("Toyota","Prius","Silver","KKO-0212",2020,39000,owner2);
		carRepository.saveAll(Arrays.asList(car1,car2,car3));

		for (Car car : carRepository.findAll()){
			logger.info(car.getBrand()+" "+car.getModel());
		}
	}
}
