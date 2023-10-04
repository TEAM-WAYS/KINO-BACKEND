package ways.kinobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ways.kinobackend.model.Seat;

import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat,String> {


    Optional<Seat> findById(int id);
}

