package ways.kinobackend.service;

import ways.kinobackend.model.Timeslot;

import java.util.List;
import java.util.Optional;

public interface TimeslotService {
    List<Timeslot> getTimeslot();

    Optional<Timeslot> postTimeslot(Timeslot timeslot);

    Optional<Timeslot> putTimeslot(Timeslot timeslot);

    boolean deleteTimeslot(int id);

    Optional<Timeslot> getTimeslotById(int id);

    boolean sortTimeslots();
}
