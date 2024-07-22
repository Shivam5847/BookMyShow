package com.example.bookmyshow.Service;

import com.example.bookmyshow.Models.Movie;
import com.example.bookmyshow.Models.Screen;
import com.example.bookmyshow.Models.Show;
import com.example.bookmyshow.Repository.ShowRepository;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.UUID;

@Service
public class ShowService {
    private ShowRepository showRepository;
    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public Show addShow(Screen screen, Movie movie, Date startTime,int duration){
             String show_Id= UUID.randomUUID().toString();
             Show show=new Show(show_Id,movie,screen,startTime,duration);
             return showRepository.save(show);
    }
}
