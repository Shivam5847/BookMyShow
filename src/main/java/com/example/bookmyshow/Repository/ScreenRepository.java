package com.example.bookmyshow.Repository;

import com.example.bookmyshow.Models.Screen;
import com.example.bookmyshow.Models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {
    Optional<Screen> findByName(String name);
    Optional<Screen> findByNameAndAndTheatre(String name, Theatre theatre);
    Optional<Screen> findById(Long id);
    Screen save(Screen screen);
}
