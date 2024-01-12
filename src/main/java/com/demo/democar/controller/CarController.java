package com.demo.democar.controller;

import com.demo.democar.dto.CarDTO;
import com.demo.democar.exception.CustomErrorType;
import com.demo.democar.model.Car;
import com.demo.democar.repository.CarJpaRepository;
import com.demo.democar.service.CarService;
import com.demo.democar.mapper.CarMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "car")
@RestController
@RequestMapping("/api/car")
public class CarController {

    public static final Logger logger = LoggerFactory.getLogger(CarController.class);

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

    @Operation(summary = "retrieve cars list",operationId = "listAllCars", tags = {"car"})
    @GetMapping("/")
    public ResponseEntity<List<CarDTO>> listAllCars() {
        List<Car> cars = carService.findAllCars();
        if (cars.isEmpty()) {
            return new ResponseEntity<List<CarDTO>>(HttpStatus.NO_CONTENT);
        }

        List<CarDTO> result = cars.stream()
            .map(u -> carMapper.mapperInstance.entityToDto(u))
            .collect(Collectors.toList());

        return new ResponseEntity<List<CarDTO>>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable("id") final Long id) {
        Car car = carService.findById(id);
        if (car == null) {
            logger.error("Car with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Car with id " + id + " not found"),
                HttpStatus.NOT_FOUND);
        }

        CarDTO mapped = carMapper.mapperInstance.entityToDto(car);
        return new ResponseEntity<CarDTO>(mapped, HttpStatus.OK);
    }
    
    @Operation(summary = "load csv file",operationId = "loadFromFile", tags = {"car"})
    @GetMapping("/loadCsvFile")
    public ResponseEntity loadFromFile() {
        try {
            carService.loadFromFile();
        } catch(Exception ex){
            ex.printStackTrace();
            return new ResponseEntity(null, HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity(null, HttpStatus.OK);
    }

    @PostMapping(value = "/queryFilter", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CarDTO>> queryFilter(@RequestBody final CarDTO filtro) {

        List<Car> cars = carService.queryFilter(filtro);

        List<CarDTO> result = cars.stream()
            .map(u -> carMapper.mapperInstance.entityToDto(u))
            .collect(Collectors.toList());

        return new ResponseEntity<List<CarDTO>>(result, HttpStatus.OK);
    }
    
}
