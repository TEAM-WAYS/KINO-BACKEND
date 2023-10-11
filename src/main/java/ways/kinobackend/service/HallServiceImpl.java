package ways.kinobackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ways.kinobackend.model.Hall;
import ways.kinobackend.repository.HallRepository;

import java.util.List;
import java.util.Optional;

@Component
public class HallServiceImpl implements HallService{
    @Autowired
    HallRepository hallRepository;

    @Override
    public List<Hall> getHall(){
        return hallRepository.findAll();
    }
    public Optional<Hall> getHallById(int hallId) {
        return hallRepository.findById(hallId);
    }
    @Override
    public Optional<Hall> postHall(Hall hall){
        return Optional.of(hallRepository.save(hall));
    }

    @Override
    public Optional<Hall> putHall(Hall hall){
        Optional<Hall> foundHall = hallRepository.findById(hall.getId());

        if (foundHall.isPresent()){
            return Optional.of(hallRepository.save(hall));
        } else return Optional.empty();
    }

    public boolean deleteHall(int id) {
        Optional<Hall> foundHall = hallRepository.findById(id);

        if (foundHall.isPresent()){
            hallRepository.delete(foundHall.get());
            return true;
        }

        return false;
    }
}
