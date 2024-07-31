package com.example.bookmyshow.Controller;

import com.example.bookmyshow.DTO.RequestDto.MovieAddDto;
import com.example.bookmyshow.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bms")
public class MovieController {

     private final MovieService movieService;
     @Autowired
     public MovieController(MovieService movieService){
         this.movieService=movieService;
     }
    @PostMapping("/addMovie")
    public String addMovie(@RequestBody MovieAddDto movieAddDto){
          return movieService.addMovie(movieAddDto.getTitle());
    }
 }
