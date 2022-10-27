package com.example.mock_1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.List;

@Entity
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parkId;

    @Positive(message = "parkArea must be positive")
    private int parkArea;
    private String parkName;
    private String parkPlace;

    @Min(value = 0, message = "parkPrice must not be negative")
    private int parkPrice;

    @Pattern(regexp = "^blank$|^full$|^available$", message = "status must be blank or full or available")
    private String parkStatus;

    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL)
    private List<Car> carList;


    public int getParkId() {
        return parkId;
    }

    public void setParkId(int parkId) {
        this.parkId = parkId;
    }

    public int getParkArea() {
        return parkArea;
    }

    public void setParkArea(int parkArea) {
        this.parkArea = parkArea;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkPlace() {
        return parkPlace;
    }

    public void setParkPlace(String parkPlace) {
        this.parkPlace = parkPlace;
    }

    public int getParkPrice() {
        return parkPrice;
    }

    public void setParkPrice(int parkPrice) {
        this.parkPrice = parkPrice;
    }

    public String getParkStatus() {
        return parkStatus;
    }

    public void setParkStatus(String parkStatus) {
        this.parkStatus = parkStatus;
    }

    public List<Car> getCar() {
        return carList;
    }

    @JsonManagedReference // use when to add or update car into parking lot
//    @JsonBackReference // use when to show result
    public void setCar(List<Car> car) {
        this.carList = car;
    }

}
