package com.example.bookmyshow.Repository;

import com.example.bookmyshow.Models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    Theatre save(Theatre theatre);
    Optional<Theatre> findByName(String name);
    Optional<Theatre> findById(Long id);
}
