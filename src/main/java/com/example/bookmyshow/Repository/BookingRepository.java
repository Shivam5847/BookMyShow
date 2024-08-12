package com.example.bookmyshow.Repository;

import com.example.bookmyshow.Models.Booking;
import com.example.bookmyshow.Models.ShowSeat;
import org.hibernate.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    Booking save(Booking booking);
    Booking findBookingById(Long id);
   // Booking findBookingById(Long bookingId);

}
