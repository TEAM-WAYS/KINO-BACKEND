package ways.kinobackend.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numberOfRows;
    private int seatsPrRow;
    private int screenSize;
    private String name;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "hall")
    @JsonBackReference
    private Set<Timeslot>  timeslot = new HashSet<>();

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int seat) {
        this.numberOfRows = seat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatsPrRow() {
        return seatsPrRow;
    }

    public void setSeatsPrRow(int seatsPrRow) {
        this.seatsPrRow = seatsPrRow;
    }

    public Set<Timeslot> getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Set<Timeslot> timeslot) {
        this.timeslot = timeslot;
    }
}
