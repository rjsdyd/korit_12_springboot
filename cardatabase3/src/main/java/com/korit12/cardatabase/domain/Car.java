package com.korit12.cardatabase.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Schema(description = "자동차 엔티티 모델")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "자동 생성되는 고유 ID",example = "1")
    private Long id;

    @NonNull
    @Schema(description = "자동차 브랜드", example = "현대")
    private String brand;
    @NonNull
    @Schema(description = "자동차 모델", example = "펠리세이드")
    private String model;
    @NonNull
    @Schema(description = "자동차 색상", example = "빨강")
    private String color;
    @NonNull
    @Schema(description = "자동차 등록번호", example = "123가4567")
    private String registrationNumber;

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
