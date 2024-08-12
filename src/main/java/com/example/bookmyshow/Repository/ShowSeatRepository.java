package com.example.bookmyshow.Repository;

import com.example.bookmyshow.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    ShowSeat save(ShowSeat showSeat);
    Optional<ShowSeat> findById(Long seatId);
    //ShowSeat findbyBooking_Id(Long bookingId);
}
