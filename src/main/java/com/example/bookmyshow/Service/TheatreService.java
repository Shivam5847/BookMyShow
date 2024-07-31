package com.example.bookmyshow.Service;

import com.example.bookmyshow.Models.Screen;
import com.example.bookmyshow.Models.Seat;
import com.example.bookmyshow.Models.SeatType;
import com.example.bookmyshow.Models.Theatre;
import com.example.bookmyshow.Repository.ScreenRepository;
import com.example.bookmyshow.Repository.SeatRepository;
import com.example.bookmyshow.Repository.TheatreRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class TheatreService {

    private final TheatreRepository theatreRepository;
    private final ScreenRepository screenRepository;
    private final SeatRepository seatRepository;

    public TheatreService(SeatRepository seatRepository,TheatreRepository theatreRepository,ScreenRepository screenRepository) {
        this.seatRepository = seatRepository;
        this.theatreRepository=theatreRepository;
        this.screenRepository=screenRepository;
    }


    public Theatre addTheatre(String theatre_name){
                 Optional<Theatre> optionalTheatre=theatreRepository.findByName(theatre_name);
                 if(!optionalTheatre.isEmpty()) return optionalTheatre.get();
                  String theatre_id= UUID.randomUUID().toString();
                  Theatre theatre = new Theatre(theatre_id,theatre_name);
                 return  theatreRepository.save(theatre);
        }

        public Screen addScreen(Theatre theatre,String screen_name){
            Optional<Screen> optionalScreen=screenRepository.findByNameAndAndTheatre(screen_name,theatre);
            if(!optionalScreen.isEmpty() && optionalScreen.get().getTheatre().getName().equals(theatre.getName())) return optionalScreen.get();
              String screen_id = UUID.randomUUID().toString();
              Screen screen=new Screen(screen_id,screen_name,theatre);
               return screenRepository.save(screen);
        }

        public Seat addSeat(int seatNumber,String seatType,Screen screen ){
        Optional<Seat> optionalSeat=seatRepository.findByseatNumber(seatNumber);
        if(!optionalSeat.isEmpty()) return optionalSeat.get();
                   Seat seat=new Seat(seatNumber, SeatType.valueOf(seatType));
                   screen.addSeat(seat);
                  return  seatRepository.save(seat);
        }
}
