package ways.kinobackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ways.kinobackend.model.Timeslot;
import ways.kinobackend.repository.TimeslotRepository;

import java.util.List;
import java.util.Optional;
@Component
public class TimeslotImpl implements TimeslotService{
    @Autowired
    TimeslotRepository timeslotRepository;

    @Override
    public List<Timeslot> getTimeslot(){
        return timeslotRepository.findAll();
    }

    @Override
    public Optional<Timeslot> postTimeslot(Timeslot timeslot){
        return Optional.of(timeslotRepository.save(timeslot));
    }

    @Override
    public Optional<Timeslot> putTimeslot(Timeslot timeslot){
        Optional<Timeslot> foundTimeslot = timeslotRepository.findById(timeslot.getId());

        if (foundTimeslot.isPresent()){
            return Optional.of(timeslotRepository.save(timeslot));
        } else return Optional.empty();
    }

    @Override
    public boolean deleteTimeslot(int id) {
        Optional<Timeslot> foundTimeslot = timeslotRepository.findById(id);

        if (foundTimeslot.isPresent()){
            timeslotRepository.delete(foundTimeslot.get());
            return true;
        }

        return false;
    }
}
