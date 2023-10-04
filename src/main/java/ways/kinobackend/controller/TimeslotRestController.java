package ways.kinobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ways.kinobackend.model.Timeslot;
import ways.kinobackend.service.TimeslotService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class TimeslotRestController {
    @Autowired
    private TimeslotService timeslotService;

    @GetMapping("/timeslots")
    public ResponseEntity<List<Timeslot>> gettimeslot() {
        List<Timeslot> timeList = timeslotService.getTimeslot();

        if (timeList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(timeList);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(timeList);
        }
    }

    @PostMapping("/timeslots")
    public ResponseEntity<?> postTime(@RequestBody Timeslot timeslot) {
        Optional<Timeslot> savedTime = timeslotService.postTimeslot(timeslot);

        if (savedTime.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedTime.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("time didn't save");
        }
    }

    @PutMapping("/timeslots")
    public ResponseEntity<?> putTime(@RequestBody Timeslot timeslot) {
        Optional<Timeslot> foundTime = timeslotService.putTimeslot(timeslot);

        if (foundTime.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("time didn't update");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(foundTime);
        }
    }

    @DeleteMapping("/timeslots/delete/{id}")
    public ResponseEntity<String> deleteTime(@PathVariable int id) {
        Boolean foundTime = timeslotService.deleteTimeslot(id);

        if (foundTime) {
            return ResponseEntity.status(HttpStatus.OK).body("timeslot deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("timeslot not deleted");
        }
    }
}