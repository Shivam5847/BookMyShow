package com.example.bookmyshow.Repository;

import com.example.bookmyshow.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Override
    Optional<Movie> findById(Long id);
    Optional<Movie> findByTitle(String title);
    Movie save(Movie movie);
}
