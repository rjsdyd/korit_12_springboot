package korit12.cardatabase00.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String brand);
    List<Car> findByColor(String color);
    List<Car> findByModelYear(int modelYear);
    List<Car> findByBrandAndModel(String brand, String model);
    List<Car> findByBrandOrColor(String brand, String color);
    List<Car> findByBrandOrderByModelYearAsc(String brand);

    @Query("select c from Car c where c.model = ?1")
    List<Car> findByModel(String model);

    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndWith(String brand);
}
