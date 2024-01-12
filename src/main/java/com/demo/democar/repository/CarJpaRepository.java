package com.demo.democar.repository;

import com.demo.democar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarJpaRepository extends JpaRepository<Car, Long> {

    Car findById(Long id);
    List<Car> findByBrand(String brand);
    List<Car> findByModel(String model);
    List<Car> findByBrandAndModel(String brand, String model);

    @Query(
        value = "SELECT * FROM CARS t " +
            " WHERE t.IS_AUTOMATIC*10 + t.IS_4WD = ?1",
        nativeQuery = true
    )
    List<Car> findByOptionals(Integer bitMap);

}
