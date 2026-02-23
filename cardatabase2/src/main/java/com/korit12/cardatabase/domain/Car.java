package com.korit12.cardatabase.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String brand, model, color, registrationNumber;

    @NonNull
    private int modelYear, price;

    public Car(@NonNull String brand,
               @NonNull String model,
               @NonNull String color,
               @NonNull String registrationNumber,
               @NonNull int modelYear,
               @NonNull int price,
               @NonNull Owner owner)
    {
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
    @JsonIgnore
    private Owner owner;
}
