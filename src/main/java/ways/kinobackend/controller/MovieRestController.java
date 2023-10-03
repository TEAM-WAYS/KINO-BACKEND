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

    /*
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
        Optional<Movie> savedMovie = movieService.postMovie(movie);

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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("movie didn't update");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(movieFound);
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
    }*/

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        return movieOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie createdMovie = movieRepository.save(movie);
        return ResponseEntity.ok(createdMovie);
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable int id, @RequestBody Movie updatedMovie) {
        Optional<Movie> existingMovieOptional = movieRepository.findById(id);
        if (existingMovieOptional.isPresent()) {
            Movie existingMovie = existingMovieOptional.get();
            existingMovie.setTitle(updatedMovie.getTitle());
            existingMovie.setDuration(updatedMovie.getDuration());
            existingMovie.setDirector(updatedMovie.getDirector());
            existingMovie.setImage(updatedMovie.getImage());
            existingMovie.setGenre(updatedMovie.getGenre());
            existingMovie.setDescription(updatedMovie.getDescription());
            existingMovie.setPegi(updatedMovie.getPegi());

            Movie updated = movieRepository.save(existingMovie);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
