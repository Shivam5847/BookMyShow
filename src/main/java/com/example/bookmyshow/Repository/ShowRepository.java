package com.example.bookmyshow.Repository;

import com.example.bookmyshow.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {
    Show save(Show show);
    Optional<Show> findById(Long id);
}
