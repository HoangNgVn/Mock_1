package com.example.mock_1.api_layer;

import com.example.mock_1.entity.ParkingLot;
import com.example.mock_1.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "parkingLot")
public class ParkingLotAPI {
    @Autowired
    private ParkingLotService parkingLotService;

    @GetMapping
    public List<ParkingLot> getAllParkingLots() {
        return parkingLotService.getAllParkingLot();
    }

    @GetMapping(path = "{parkingLotId}")
    public Optional<ParkingLot> getParkingLotById(@PathVariable("parkingLotId") int id) {
        return parkingLotService.getParkingLot(id);
    }

    @GetMapping(path = "status/{status}")
    public List<ParkingLot> findParkingLotByStatus(@PathVariable("status") String status){
        return parkingLotService.findParkingLotByStatus(status);
    }

    @PostMapping
    public ResponseEntity<ParkingLot> addParkingLot(@RequestBody @Valid ParkingLot parkingLot) {
        return new ResponseEntity<ParkingLot>(parkingLotService.addParkingLot(parkingLot), HttpStatus.CREATED);
    }

    @PutMapping(path = "{parkingLotId}")
    public ResponseEntity<ParkingLot> updateParkingLot(@PathVariable("parkingLotId") int id, @RequestBody @Valid ParkingLot parkingLot) {
        return new ResponseEntity<>(parkingLotService.updateParkingLot(id, parkingLot), HttpStatus.OK);
    }

    @DeleteMapping(path = "{parkingLotId}")
    public String deleteParkingLot(@PathVariable("parkingLotId") int id) {
        return parkingLotService.deleteParkingLot(id);
    }
}
