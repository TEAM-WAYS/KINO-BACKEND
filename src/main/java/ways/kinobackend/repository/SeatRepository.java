package ways.kinobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ways.kinobackend.model.Seat;

public interface SeatRepository extends JpaRepository<Seat,String> {
}

