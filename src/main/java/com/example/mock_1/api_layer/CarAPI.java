package com.example.mock_1.api_layer;


import com.example.mock_1.entity.Car;
import com.example.mock_1.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "car")
public class CarAPI {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCar();
    }

    @GetMapping(path = "{car_license}")
    public Optional<Car> getCarById(@PathVariable("car_license") String license) {
        return carService.getCar(license);
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody @Valid Car car) {
        return new ResponseEntity<Car> (carService.addCar(car), HttpStatus.CREATED);
    }

    @PutMapping(path = "{car_license}")
    public ResponseEntity<Car> updateCar(@PathVariable("car_license") String license, @RequestBody @Valid Car car) {
        return new ResponseEntity<>(carService.updateCar(license, car), HttpStatus.OK);
    }

    @DeleteMapping(path = "{car_license}")
    public String deleteCar(@PathVariable("car_license") String license) {
        return carService.deleteCar(license);
    }

}

