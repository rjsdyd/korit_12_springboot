package korit12.cardatabase00.domain;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Car() {
    }

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
}
