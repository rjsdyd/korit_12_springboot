package com.korit12.cardatabase.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    // CrudRepository에 없는 메서드라면 여기에 정의해줘야 함.
    // 쿼리는 접두사로 시작해야하고, 쿼리에 이용할 엔티티 클래스 필드를 정의해야 함.

    List<Car> findByBrand(String brand);

    // 색상으로 검정색, 그리고 연도를 검색하는 메서드를 직접 정의하시오.
    List<Car> findByColor(String color);
    List<Car> findByModelYear(int modelYear);

    // SQL 상에서의 AND 및 OR 연산자도 적용이 됨.
    // 브랜드와 모델로 자동차 검색
    List<Car> findByBrandAndModel(String brand, String model);

    // 브랜드 또는 색상 별로 자동차 가져오기 작성하시오.
    List<Car> findByBrandOrColor(String brand, String color);

    // 정렬도 집어넣을 수 있음 - 브랜드로 자동차 검색하고, 연도로 정렬
    List<Car> findByBrandOrderByModelYearAsc(String brand);

    // @Query 애너테이션을 이용해서 SQL문 자체를 집어넣을 수 있음.
    // 모델명으로 검색
    @Query("select c from Car c where c.model = ?1")
    List<Car> findByModel(String model);
    // 그런데 이상의 경우에는 일치하는 것만 구할 수가 있는데, @Query를 쓰는 이유는 LIKE
    // 연산자가 사용가능하기에....

    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndWith(String brand);

    // 다만 @Query를 쓰게 되면 다른 데이터베이스로의 이식성이 좀 떨어지긴 함.
}
