package com.demo.democar.service;

import com.demo.democar.dto.CarDTO;
import com.demo.democar.dto.CsvDTO;
import com.demo.democar.mapper.CarMapper;
import com.demo.democar.model.Car;
import com.demo.democar.repository.CarFilterRepository;
import com.demo.democar.repository.CarJpaRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

@Service("carService")
public class CarService {
  private CarJpaRepository carJpaRepository;
  private CarFilterRepository carFilterRepository;
  private CarMapper carMapper;

  @Autowired
  public void setCarJpaRepository(CarJpaRepository carJpaRepository) {
    this.carJpaRepository = carJpaRepository;
  }

  @Autowired
  public void setCarFilterRepository(CarFilterRepository carFilterRepository) {
    this.carFilterRepository = carFilterRepository;
  }

  public Car findById(Long id) {
    return carJpaRepository.findById(id);
  }

  public List<Car> findAllCars() {
    List<Car> cars = carJpaRepository.findAll();
    if (cars.isEmpty()) {
      return null;
    }
    return cars;
  }

  @Transactional
  public void loadFromFile() throws IOException {
    URL url = new URL("http://localhost:8080/data/cars.csv");

    List<CsvDTO> beans = new CsvToBeanBuilder(
        new BufferedReader(
            new InputStreamReader(url.openStream()))
    ).withType(CsvDTO.class)
        .build()
        .parse();

    _loadBulkData(beans);

  }

  public List<Car> queryFilter(CarDTO dto)   {

    return carFilterRepository.cercaDaFilro(dto);
  }



  private void _loadBulkData(List<CsvDTO> data){
    for(CsvDTO csv: data) {
      Car car = new Car();

      car.setBrand(csv.getBrand());
      car.setModel(csv.getModel());
      car.setPowerType(csv.getPowerType());
      car.setAgeType(Integer.valueOf(csv.getAgeType()));
      car.setPriceType(Integer.valueOf(csv.getPriceType()));
      car.setIs4wd(csv.getIs4wd().equals("1"));
      car.setIsAutomatic(csv.getIsAutomatic().equals("1"));

      carJpaRepository.save(car);
    }


  }
}
