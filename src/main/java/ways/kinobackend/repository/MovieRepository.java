package ways.kinobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ways.kinobackend.model.Movie;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, String> {

    Optional<Movie> findById(int id);

    void deleteById(int id);

    boolean existsById(int id);
}
