package com.example.mock_1.service;

import com.example.mock_1.entity.ParkingLot;
import com.example.mock_1.exception.NotFoundException;
import com.example.mock_1.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingLotService {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public List<ParkingLot> getAllParkingLot() {
        return parkingLotRepository.findAll();
    }

    public Optional<ParkingLot> getParkingLot(int id) {
        return parkingLotRepository.findById(id);
    }

    public ParkingLot addParkingLot(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);

    }

    public ParkingLot updateParkingLot(int id, ParkingLot new_parkingLot) {
        Optional<ParkingLot> old_parkingLot = parkingLotRepository.findById(id);
        if (!old_parkingLot.isPresent()) {
            throw new NotFoundException("Can't update, ParkingLot doesn't exist ");
        }
        new_parkingLot.setParkId(id);
        return parkingLotRepository.save(new_parkingLot);
    }

    public String deleteParkingLot(int id) {
        Optional<ParkingLot> parkingLotToDelete = parkingLotRepository.findById(id);
        if (!parkingLotToDelete.isPresent()) {
            throw new NotFoundException("It's not have that parkingLot");
        }
        parkingLotRepository.deleteById((Integer) id);
        return "Delete successfully";
    }

    public List<ParkingLot> findParkingLotByStatus(String status){
        return parkingLotRepository.findParkingLotByStatus(status);
    }
}
