package com.example.mock_1.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class BookingOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int officeId;

    private LocalDate endContractDeadline;

    @NotBlank(message = "officeName must not blank")
    private String officeName;

    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", message = "Invalid officePhone number")
    private String officePhone;

    private String officePlace;

    @Min(value = 0, message = "officePrice must not be negative")
    private int officePrice;

    private LocalDate startContractDeadline;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    public int getOfficeId() {
        return officeId;
    }

    public LocalDate getEndContractDeadline() {
        return endContractDeadline;
    }

    public String getOfficeName() {
        return officeName;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public String getOfficePlace() {
        return officePlace;
    }

    public int getOfficePrice() {
        return officePrice;
    }

    public LocalDate getStartContractDeadline() {
        return startContractDeadline;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public void setEndContractDeadline(LocalDate endContractDeadline) {
        this.endContractDeadline = endContractDeadline;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public void setOfficePlace(String officePlace) {
        this.officePlace = officePlace;
    }

    public void setOfficePrice(int officePrice) {
        this.officePrice = officePrice;
    }

    public void setStartContractDeadline(LocalDate startContractDeadline) {
        this.startContractDeadline = startContractDeadline;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

}
