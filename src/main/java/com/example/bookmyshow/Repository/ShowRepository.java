package com.example.bookmyshow.Repository;

import com.example.bookmyshow.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    Show save(Show show);
    Optional<Show> findById(Long id);
    Optional<Show> findByShowId(String id);
}
