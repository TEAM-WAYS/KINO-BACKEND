package ways.kinobackend.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Timeslot {
    private LocalTime start;
    private LocalTime end;

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
}
