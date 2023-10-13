package ways.kinobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ways.kinobackend.model.Timeslot;

import java.util.List;
import java.util.Optional;

public interface TimeslotRepository extends JpaRepository<Timeslot,String> {
    Optional<Timeslot> findById(int id);

}
