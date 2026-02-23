package com.korit12.cardatabase;

import com.korit12.cardatabase.domain.Car;
import com.korit12.cardatabase.domain.CarRepository;
import com.korit12.cardatabase.domain.Owner;
import com.korit12.cardatabase.domain.OwnerRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;

import java.util.Arrays;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner{
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

    public CardatabaseApplication(CarRepository repository, CarRepository carRepository, OwnerRepository ownerRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("애플리케이션이 실행됩니다.");
	}
	private final CarRepository carRepository;
	private final OwnerRepository ownerRepository;

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("김", "일");
		Owner owner2 = new Owner("Jone", "Doe");
		ownerRepository.saveAll(Arrays.asList(owner1,owner2));

		carRepository.save(new Car
				("현대", "소나타", "검정", "123가4567", 2026, 30000000, owner1)
		);
		carRepository.save(new Car
				("기아", "K9", "흰색", "153가4867", 2025, 400000000, owner2)
		);
		carRepository.save(new Car
				("롤스로이스", "스펙터", "검정", "777가7777", 2026, 1000000000, owner2)
		);
	}
}
