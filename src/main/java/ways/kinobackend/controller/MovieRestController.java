package ways.kinobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ways.kinobackend.model.Movie;
import ways.kinobackend.repository.MovieRepository;
import ways.kinobackend.service.MovieService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class MovieRestController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movieList = movieService.getMovies();

        if (movieList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(movieList);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(movieList);
        }
    }

    @PostMapping("/movies")
    public ResponseEntity<?> postMovie(@RequestBody Movie movie){
        //HTTP Post request med Movie object i JSON format i en request body
        Optional<Movie> savedMovie = movieService.postMovie(movie);
        //kalder postMovie metode i movieservice som har logiken til at lave og gemme Movie
        //checker om savedmovie container en værdi
        if (savedMovie.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("movie didn't save");
        }
    }


    @PutMapping("/movies")
    public ResponseEntity<?> putMovie(@RequestBody Movie movie){
        Optional<Movie> foundMovie = movieService.putMovie(movie);

        if (foundMovie.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found or couldn't be updated");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Movie updated successfully");
        }
    }

    @DeleteMapping("/movies/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable int id){
        Boolean foundMovie = movieService.deleteMovie(id);

        if (foundMovie){
            return ResponseEntity.status(HttpStatus.OK).body("movie deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("movie not deleted");
        }
    }
    @GetMapping("/movies/{movieId}")
    public ResponseEntity<?> getMovieById(@PathVariable int movieId) {
        Optional<Movie> foundMovie = movieService.getMovieById(movieId);

        if (foundMovie.isPresent()) {
            return ResponseEntity.ok(foundMovie.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
        }
    }
}
