package com.demo.democar.controller;

import com.demo.democar.dto.CarDTO;
import com.demo.democar.mapper.CarMapper;
import com.demo.democar.model.Car;
import com.demo.democar.repository.CarJpaRepository;
import com.demo.democar.service.CarService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.stream.Collectors;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarControllerTest extends TestCase {
  private CarJpaRepository carJpaRepository;
  private CarService carService;
  private CarMapper carMapper;

  @Autowired
  public void setCarJpaRepository(CarJpaRepository carJpaRepository) {

    this.carJpaRepository = carJpaRepository;
  }

  @Autowired
  public void setCarService(CarService carService) {

    this.carService = carService;
  }

  @Test
  public void testFindAllCars()  {
    List<Car> cars = carService.findAllCars();
    assertTrue(!cars.isEmpty());

    List<CarDTO> result = cars.stream()
        .map(u -> carMapper.mapperInstance.entityToDto(u))
        .collect(Collectors.toList());

    assertTrue(!result.isEmpty());
  }

  @Test
  public void testFindByFilter()  {
    CarDTO dto = new CarDTO();

    dto.setBrand("brand1");
    List<Car> cars = carService.queryFilter(dto);
    assertTrue(!cars.isEmpty());
    assertTrue(cars.get(0).getBrand().equals("brand1"));
  }

}
