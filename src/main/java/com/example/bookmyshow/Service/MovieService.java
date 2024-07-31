package com.example.bookmyshow.Service;

import com.example.bookmyshow.Models.Movie;
import com.example.bookmyshow.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public String addMovie(String title){
        Optional<Movie> movieOptional = movieRepository.findByTitle(title);
       // return movieOptional.orElseGet(() -> movieRepository.save(movie));
        if(!movieOptional.isEmpty()) return "Movie Already Exists";
        Movie movie = new Movie(title);
        movieRepository.save(movie);
        return "Movie successfully added";
    }
}
