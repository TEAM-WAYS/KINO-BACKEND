package ways.kinobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ways.kinobackend.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {
}
