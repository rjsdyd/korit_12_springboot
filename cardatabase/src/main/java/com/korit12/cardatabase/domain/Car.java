package com.korit12.cardatabase.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
// Lombok을 의존성 주입하고, Car 클래스를 롬복 적용 버전으로 다 수정하시오,.
// 이후 동일하게 동일하게 localhost:8080/h2-console 을 통해 접속해 성공하시오.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String brand, model, color, registrationNumber;

    @NonNull
    private int modelYear, price;

    public Car(@NonNull String brand, @NonNull String model, @NonNull String color, @NonNull String registrationNumber, @NonNull int modelYear, @NonNull int price, @NonNull Owner owner) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.modelYear = modelYear;
        this.price = price;
        this.owner = owner;
    }

    @ManyToOne
    @JoinColumn(name = "owner")
    @NonNull
    private Owner owner;

    // @NonNull이 없으니까 얘는 옵셔널이라고 봐야함.
}
