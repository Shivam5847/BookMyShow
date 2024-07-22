package com.example.bookmyshow.Controller;

import com.example.bookmyshow.DTO.ShowAddRequestDTO;
import com.example.bookmyshow.Models.Movie;
import com.example.bookmyshow.Models.Screen;
import com.example.bookmyshow.Models.Show;
import com.example.bookmyshow.Repository.MovieRepository;
import com.example.bookmyshow.Repository.ScreenRepository;
import com.example.bookmyshow.Service.ShowService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/show")
public class ShowController {
    private ScreenRepository screenRepository;
    private MovieRepository movieRepository;
    private ShowService showService;

    public ShowController(ScreenRepository screenRepository,
                          MovieRepository movieRepository,ShowService showService){
        this.screenRepository = screenRepository;
        this.movieRepository = movieRepository;
        this.showService = showService;

    }
    @PostMapping("/add")
    public String addshow(@RequestBody ShowAddRequestDTO showAddRequestDTO){
        Optional<Screen> optionalScreen = screenRepository.findById(showAddRequestDTO.getScreenId());
        Optional<Movie> optionalMovie = movieRepository.findById(showAddRequestDTO.getMovieId());
        return showService.addShow(optionalScreen.get(),optionalMovie.get(),
                showAddRequestDTO.getStartTime(),showAddRequestDTO.getDuration()).getShow_Id();

    }
}
