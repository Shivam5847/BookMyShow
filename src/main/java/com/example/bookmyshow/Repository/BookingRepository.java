package com.example.bookmyshow.Repository;

import com.example.bookmyshow.Models.Booking;
import com.example.bookmyshow.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking save(Booking booking);
    List<ShowSeat> findShowSeatsById(Long bookingId);
    Booking findBookingById(Long bookingId);
}
