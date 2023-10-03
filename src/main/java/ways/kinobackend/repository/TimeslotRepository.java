package ways.kinobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ways.kinobackend.model.Timeslot;

public interface TimeslotRepository extends JpaRepository<Timeslot,String> {
}
