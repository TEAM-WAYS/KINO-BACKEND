package ways.kinobackend.coparetor;

import ways.kinobackend.model.Timeslot;

import java.util.Comparator;

public class TimeslotStarttimeComparator implements Comparator<Timeslot> {
    @Override
    public int compare(Timeslot timeslot1, Timeslot timeslot2) {
        if(timeslot1.getStart().isBefore(timeslot2.getStart())){
            return 1;
        }else if(timeslot2.getStart().isBefore(timeslot1.getStart())){
            return -1;
        }
        return 0;
    }
}
