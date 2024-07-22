package com.example.bookmyshow.Repository;

import com.example.bookmyshow.Models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    Seat save(Seat seat);
    Optional<Seat> findById(Long id);
    Optional<Seat> findByseatNumber(int seatNumber);
}
