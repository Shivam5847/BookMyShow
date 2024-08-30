package com.example.bookmyshow.Service;

import com.example.bookmyshow.DTO.RequestDto.ShowSeatAddRequestDTO;
import com.example.bookmyshow.Models.*;
import com.example.bookmyshow.Repository.SeatRepository;
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
    private final SeatRepository seatRepository;

    public ShowService(ShowRepository showRepository, ShowSeatRepository showSeatRepository, SeatRepository seatRepository) {
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.seatRepository = seatRepository;
    }

    public Show addShow(Screen screen, Movie movie, Date startTime,int duration){
             String showId= UUID.randomUUID().toString();
             Theatre theatre=screen.getTheatre();
             Show show=new Show(showId,movie,screen,startTime,duration);
             List<Seat> seatList=screen.getSeatList();
             theatre.getShows().add(show);
             Show savedShow=showRepository.save(show);
             return savedShow;
    }

    public void addShowSeat(ShowSeatAddRequestDTO showSeatAddRequestDTO){
        System.out.println("in add show seat");
        Show show=showRepository.findById(showSeatAddRequestDTO.getShowId()).get();
        System.out.println("got the show");
        for(Long seatId: showSeatAddRequestDTO.getShowSeatId()){
            Seat seat=seatRepository.findById(seatId).get();
            System.out.println("got the seat ");
            ShowSeat showSeat=new ShowSeat(show,seat, showSeatAddRequestDTO.getPrice());
            System.out.println("show seat added");
            showSeatRepository.save(showSeat);
            System.out.println("show seat saved");
        }
    }
}
