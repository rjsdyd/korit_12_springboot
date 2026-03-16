package com.korit12.cardatabase;

import com.korit12.cardatabase.domain.*;
import lombok.Getter;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner{
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

    public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("애플리케이션이 실행됩니다.");
	}
	private final CarRepository carRepository;
	private final OwnerRepository ownerRepository;
    @Getter
    private final AppUserRepository appUserRepository;

	public CardatabaseApplication(CarRepository carRepository, OwnerRepository ownerRepository, AppUserRepository appUserRepository) {
		this.carRepository = carRepository;
		this.ownerRepository = ownerRepository;
		this.appUserRepository = appUserRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// 1. Owner 데이터 생성 (10명)
		Owner o1 = new Owner("김", "철수");
		Owner o2 = new Owner("이", "영희");
		Owner o3 = new Owner("John", "Doe");
		Owner o4 = new Owner("Jane", "Smith");
		Owner o5 = new Owner("박", "민수");
		Owner o6 = new Owner("최", "지우");
		Owner o7 = new Owner("Michael", "Jordan");
		Owner o8 = new Owner("정", "다은");
		Owner o9 = new Owner("강", "호동");
		Owner o10 = new Owner("Emily", "Brown");

		ownerRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5, o6, o7, o8, o9, o10));

		// 2. Car 데이터 생성 (30대)
		List<Car> cars = Arrays.asList(
				// 테슬라 (Tesla)
				new Car("테슬라", "Model 3", "화이트", "301파3456", 2023, 60000000, o3),
				new Car("테슬라", "Model Y", "레드", "302하7890", 2024, 75000000, o4),
				new Car("테슬라", "Model S", "블랙", "303거1357", 2022, 120000000, o7),

				// 독일 브랜드 (BMW, Mercedes, Audi)
				new Car("BMW", "5시리즈", "블루", "401너2468", 2023, 70000000, o5),
				new Car("BMW", "X5", "화이트", "402더9753", 2024, 95000000, o6),
				new Car("벤츠", "E-Class", "실버", "501러1122", 2023, 85000000, o1),
				new Car("벤츠", "S-Class", "검정", "502머3344", 2024, 160000000, o2),
				new Car("아우디", "A6", "그레이", "601버5566", 2022, 68000000, o8),
				new Car("아우디", "Q7", "네이비", "602서7788", 2023, 90000000, o9),

				// 스포츠카 & 럭셔리 (Porsche, Lamborghini, Ferrari)
				new Car("포르쉐", "911 Carrera", "옐로우", "701어9900", 2024, 180000000, o10),
				new Car("람보르기니", "우라칸", "그린", "702저2233", 2023, 350000000, o7),
				new Car("페라리", "296 GTB", "레드", "703처4455", 2024, 400000000, o4),

				// 기타 브랜드 (Toyota, Honda, Volvo, Ford, Jeep)
				new Car("토요타", "캠리", "실버", "801커6677", 2022, 38000000, o3),
				new Car("혼다", "어코드", "블랙", "802터8899", 2021, 36000000, o5),
				new Car("볼보", "XC90", "흰색", "803퍼0011", 2024, 85000000, o6),
				new Car("포드", "머스탱", "블루", "901허2233", 2022, 55000000, o9),
				new Car("지프", "랭글러", "샌드", "902노4455", 2023, 65000000, o10),
				new Car("폭스바겐", "골프", "레드", "903도6677", 2021, 32000000, o8)
		);

		carRepository.saveAll(cars);

		// 3. 사용자 데이터 생성
		appUserRepository.save(new AppUser("user", "$2a$12$y2Uh2YuP.oabba6cLTTWteLDnSQ3ke9rFQn3kFvqrJay/IpBeOrEC", "User"));
		appUserRepository.save(new AppUser("admin", "$2a$12$To9/Z9IJTWrwlD8Xs1.v8e5Ps4AZR9VSaac7fMP7.gHc98dvUmV6.", "ADMIN"));

		logger.info("총 {}명의 차주와 {}대의 차량 데이터가 로드되었습니다.", ownerRepository.count(), carRepository.count());
	}
}

