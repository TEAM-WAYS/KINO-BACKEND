package ways.kinobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ways.kinobackend.model.Hall;

public interface HallRepository extends JpaRepository<Hall, String> {
}
