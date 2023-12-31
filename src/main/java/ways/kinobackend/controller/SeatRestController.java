package ways.kinobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ways.kinobackend.model.Seat;
import ways.kinobackend.service.SeatService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class SeatRestController {



        @Autowired
        private SeatService seatService;

        @GetMapping("/seats")
        public ResponseEntity<List<Seat>> getSeats() {
            List<Seat> seatList = seatService.getSeats();

            if (seatList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(seatList);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(seatList);
            }
        }
        @GetMapping("/seats/{timeslotId}")
        public ResponseEntity<List<Seat>> getSeatWhereTimeslotId(@PathVariable int timeslotId){
            List<Seat> timeslotSeatList = seatService.getSeatWhereTimeslotId(timeslotId);
            /*
            List<Seat> timslotSeatList = new ArrayList<>();
            List<Seat>  seats = seatService.getSeats();
            for(Seat seat : seats){
                if(seat.getTimeslot().getId()==timeslotId){
                    timslotSeatList.add(seat);
                }
            }

             */
            if (timeslotSeatList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(timeslotSeatList);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(timeslotSeatList);
            }

        }


        @PostMapping("/seat")
        public ResponseEntity<?> createSeat(@RequestBody Seat seat) {
            Optional<Seat> savedSeat = seatService.createSeat(seat);

            if (savedSeat.isPresent()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(savedSeat.get());
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Seat couldn't be created");
            }
        }

        @PutMapping("/seat/{id}")
        public ResponseEntity<?> updateSeat(@PathVariable int id, @RequestBody Seat seat) {
            Optional<Seat> updatedSeat = seatService.updateSeat(id, seat);

            if (updatedSeat.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(updatedSeat.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Seat not found or couldn't be updated");
            }
        }

        @DeleteMapping("/seat/delete/{id}")
        public ResponseEntity<String> deleteSeat(@PathVariable int id) {
            boolean isDeleted = seatService.deleteSeat(id);

            if (isDeleted) {
                return ResponseEntity.status(HttpStatus.OK).body("Seat deleted");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Seat not found or couldn't be deleted");
            }
        }
    }

