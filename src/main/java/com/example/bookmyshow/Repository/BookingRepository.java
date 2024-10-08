package com.example.bookmyshow.Repository;

import com.example.bookmyshow.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    Booking save(Booking booking);
    Booking findBookingById(Long id);
    Booking findByBookingId(String bookingId);

}
