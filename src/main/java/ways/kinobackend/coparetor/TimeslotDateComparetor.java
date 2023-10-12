package ways.kinobackend.coparetor;

import ways.kinobackend.model.Timeslot;

import java.util.Comparator;

public class TimeslotDateComparetor implements Comparator<Timeslot> {


    @Override
    public int compare(Timeslot timeslot1, Timeslot timeslot2) {
        if(timeslot1.getDate().isBefore(timeslot2.getDate())){
            return -1;
        }else if(timeslot2.getDate().isBefore(timeslot1.getDate())){
            return 1;
        }
        return 0;
    }
}
