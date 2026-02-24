package com.korit12.cardatabase.domain;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@Tag(name = "Car API", description = "자동차 정보 CRUD 및 검색 API")
@RepositoryRestResource(path = "vehicles")
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(@Param("brand") String brand);
    List<Car> findByColor(@Param("color") String color);
}
