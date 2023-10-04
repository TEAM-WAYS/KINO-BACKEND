package ways.kinobackend.service;


import ways.kinobackend.model.Hall;

import java.util.List;
import java.util.Optional;

public interface HallService {
    List<Hall> getHall();

    Optional<Hall> postHall(Hall hall);

    Optional<Hall> putHall(Hall hall);

    boolean deleteHall(int id);
}
