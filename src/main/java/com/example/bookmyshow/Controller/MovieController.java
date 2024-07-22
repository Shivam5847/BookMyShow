package com.example.bookmyshow.Controller;

import com.example.bookmyshow.Models.Movie;
import com.example.bookmyshow.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

     private final MovieService movieService;
     @Autowired
     public MovieController(MovieService movieService){
         this.movieService=movieService;
     }
    @PostMapping("/add")
    public Movie addMovie(@RequestBody Movie movie){
          return movieService.addMovie(movie);
    }
 }
