package com.example.bookmyshow.Controller;

import com.example.bookmyshow.DTO.RequestDto.MovieAddDto;
import com.example.bookmyshow.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> addMovie(@RequestBody MovieAddDto movieAddDto){
         try{
             movieService.addMovie(movieAddDto.getTitle());
         } catch (Exception e) {
             return new ResponseEntity<>("Movie cannot be added", HttpStatus.BAD_REQUEST);
         }
         return new ResponseEntity<>("Movie added successfully", HttpStatus.OK);

    }
 }
