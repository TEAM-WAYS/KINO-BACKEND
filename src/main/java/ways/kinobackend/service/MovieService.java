package ways.kinobackend.service;

import ways.kinobackend.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService{
    List<Movie> getMovies();
    Optional<Movie> getMovieById(int id);
    Optional<Movie> postMovie(Movie movie);

    Optional<Movie> putMovie(Movie movie);

    boolean deleteMovie(int id);
}
