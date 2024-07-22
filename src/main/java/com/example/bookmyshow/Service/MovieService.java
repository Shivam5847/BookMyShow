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
    public Movie addMovie(Movie movie){
        Optional<Movie> movieOptional = movieRepository.findByTitle(movie.getTitle());
       // return movieOptional.orElseGet(() -> movieRepository.save(movie));
        if(!movieOptional.isEmpty()) return movieOptional.get();
        return movieRepository.save(movie);
    }


}
