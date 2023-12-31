package ways.kinobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ways.kinobackend.DTO.ApiResponse;
import ways.kinobackend.model.Hall;
import ways.kinobackend.service.HallService;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin
public class HallRestController {
    @Autowired
    private HallService hallService;

    @GetMapping("/halls")
    public ResponseEntity<List<Hall>> getHalls() {
        List<Hall> hallList = hallService.getHall();

        if (hallList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hallList);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(hallList);
        }
    }

    @PostMapping("/halls")
    public ResponseEntity<?> postHall(@RequestBody Hall hall) {
        Optional<Hall> savedHall = hallService.postHall(hall);

        if (savedHall.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedHall.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("hall didn't save");
        }
    }

    @PutMapping("/halls")
    public ResponseEntity<ApiResponse> putHall(@RequestBody Hall hall) {
        Optional<Hall> foundHall = hallService.putHall(hall);

        if (foundHall.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("hall not found or couldn't be updated"));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("hall updated successfully"));
        }
    }
    @DeleteMapping("/halls/delete/{id}")
    public ResponseEntity<String> deleteHall(@PathVariable int id) {
        Boolean foundHall = hallService.deleteHall(id);

        if (foundHall) {
            return ResponseEntity.status(HttpStatus.OK).body("hall deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("hall not deleted");
        }
    }
    @GetMapping("/halls/{hallId}")
    public ResponseEntity<?> getHallById(@PathVariable int hallId) {
        Optional<Hall> foundHall = hallService.getHallById(hallId);

        if (foundHall.isPresent()) {
            return ResponseEntity.ok(foundHall.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hall not found");
        }
    }
}
