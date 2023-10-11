package ways.kinobackend.service;

import ways.kinobackend.model.Seat;

import java.util.List;
import java.util.Optional;

    public interface SeatService {

        List<Seat> getSeats();
        List<Seat>getSeatWhereTimeslotId(int id);
        Optional<Seat> createSeat(Seat seat);

        Optional<Seat> updateSeat(int id, Seat seat);

        boolean deleteSeat(int id);


    }



