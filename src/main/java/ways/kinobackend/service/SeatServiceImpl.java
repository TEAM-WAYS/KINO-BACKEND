package ways.kinobackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ways.kinobackend.model.Seat;
import ways.kinobackend.repository.SeatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public List<Seat> getSeats() {
        return seatRepository.findAll();
    }

    @Override
    public Optional<Seat> createSeat(Seat seat) {
        return Optional.of(seatRepository.save(seat));
    }

    @Override
    public Optional<Seat> updateSeat(int id, Seat seat) {
        Optional<Seat> foundSeat = seatRepository.findById(id);

        if (foundSeat.isPresent()) {
            seat.setId(id);
            return Optional.of(seatRepository.save(seat));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteSeat(int id) {
        Optional<Seat> foundSeat = seatRepository.findById(id);

        if (foundSeat.isPresent()) {
            seatRepository.delete(foundSeat.get());
            return true;
        }

        return false;
    }


}