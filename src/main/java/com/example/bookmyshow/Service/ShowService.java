package com.example.bookmyshow.Service;

import com.example.bookmyshow.Models.*;
import com.example.bookmyshow.Repository.ShowRepository;
import com.example.bookmyshow.Repository.ShowSeatRepository;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ShowService {
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
    public ShowService(ShowRepository showRepository, ShowSeatRepository showSeatRepository) {
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
    }

    public Show addShow(Screen screen, Movie movie, Date startTime,int duration){

             String show_Id= UUID.randomUUID().toString();
             Show show=new Show(show_Id,movie,screen,startTime,duration);
             List<Seat> seatList=screen.getSeatList();
             Show savedShow=showRepository.save(show);
             addShowSeat(show,seatList);
             return savedShow;

    }

    public void addShowSeat(Show show, List<Seat> seatList){
        for(Seat seat:seatList){
            ShowSeat showSeat=new ShowSeat(show,seat);
            showSeatRepository.save(showSeat);
        }
    }
}
