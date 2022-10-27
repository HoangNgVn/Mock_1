package com.example.mock_1.service;

import com.example.mock_1.entity.Car;
import com.example.mock_1.exception.NotFoundException;
import com.example.mock_1.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    public Optional<Car> getCar(String licensePlate) {
        return carRepository.findByLicensePlate(licensePlate);
    }

    public Car addCar(Car car) {
        return carRepository.save(car);

    }

    public Car updateCar(String licensePlate, Car new_car) {
        Optional<Car> old_car = carRepository.findByLicensePlate(licensePlate);
        if (!old_car.isPresent()) {
            throw new NotFoundException("Can't update, Car doesn't exist ");
        }
        new_car.setLicensePlate(licensePlate);
        return carRepository.save(new_car);
    }

    public String deleteCar(String licensePlate) {
        Optional<Car> carToDelete = carRepository.findByLicensePlate(licensePlate);
        if (!carToDelete.isPresent()) {
            throw new NotFoundException("It's not have that car");
        }
        carRepository.deleteByLicensePlate(licensePlate);
        return "Delete successfully";
    }

}

