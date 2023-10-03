package ways.kinobackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ways.kinobackend.model.Movie;
import ways.kinobackend.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Component
public class MovieServiceImpl implements MovieService{
    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> postMovie(Movie movie){
        return Optional.of(movieRepository.save((movie)));
    }

    public Optional<Movie> putMovie(Movie movie){
        Optional<Movie> foundMovie = movieRepository.findById(movie.getId());

        if (foundMovie.isPresent()){
            return Optional.of(movieRepository.save(movie));
        } else return Optional.empty();
    }

    public boolean deleteMovie(int id) {
        Optional<Movie> foundMovie = movieRepository.findById(id);

        if (foundMovie.isPresent()){
            movieRepository.delete(foundMovie.get());
            return true;
        }

        return false;
    }
}
