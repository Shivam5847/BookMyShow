package com.example.bookmyshow.Controller;

import com.example.bookmyshow.DTO.RequestDto.ShowAddRequestDTO;
import com.example.bookmyshow.DTO.RequestDto.ShowSeatAddRequestDTO;
import com.example.bookmyshow.Models.Movie;
import com.example.bookmyshow.Models.Screen;
import com.example.bookmyshow.Repository.MovieRepository;
import com.example.bookmyshow.Repository.ScreenRepository;
import com.example.bookmyshow.Service.ShowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/bms/show")
public class ShowController {
    private final ScreenRepository screenRepository;
    private final MovieRepository movieRepository;
    private final ShowService showService;

    public ShowController(ScreenRepository screenRepository,
                          MovieRepository movieRepository,ShowService showService){
        this.screenRepository = screenRepository;
        this.movieRepository = movieRepository;
        this.showService = showService;
    }
    @PostMapping("/addShow")
    public ResponseEntity<String> addShow(@RequestBody ShowAddRequestDTO showAddRequestDTO){
        Optional<Screen> optionalScreen = screenRepository.findById(showAddRequestDTO.getScreenId());
        Optional<Movie> optionalMovie = movieRepository.findById(showAddRequestDTO.getMovieId());
         try{
             showService.addShow(optionalScreen.get(),optionalMovie.get(),
                     showAddRequestDTO.getStartTime(),showAddRequestDTO.getDuration()).getShowId();
         }
         catch(Exception e){
             return new ResponseEntity<>("Show couldn't added Successfully", HttpStatus.BAD_REQUEST);
         }
         return new ResponseEntity<>("Show added successfully", HttpStatus.OK);
    }
     @PostMapping("/addShowSeat")
    public ResponseEntity<String> addShowSeat(@RequestBody ShowSeatAddRequestDTO showSeatAddRequestDTO){
        try{
            System.out.println("aa gye!");
            showService.addShowSeat(showSeatAddRequestDTO);
        }
        catch(Exception e){
            return new ResponseEntity<>("ShowSeat couldn't added Successfully", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("ShowSeat added successfully", HttpStatus.OK);

    }
}
