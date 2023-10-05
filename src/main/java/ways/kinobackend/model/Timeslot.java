package ways.kinobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Timeslot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalTime start;
    private LocalTime end;

    @ManyToOne
    @JoinColumn(name = "hall", referencedColumnName = "id")
    Hall hall;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "timeslot")
    @JsonBackReference
    private Set<Movie> movies = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "timeslot")
    @JsonBackReference
    private Set<Seat> seats = new HashSet<>();

    //price of the movie missing
    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

}
