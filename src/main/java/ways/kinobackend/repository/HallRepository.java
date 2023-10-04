package ways.kinobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ways.kinobackend.model.Hall;

import java.util.Optional;

public interface HallRepository extends JpaRepository<Hall, String> {
    Optional<Hall> findById(int id);
}
