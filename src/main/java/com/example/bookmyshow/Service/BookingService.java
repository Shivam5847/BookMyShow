package com.example.bookmyshow.Service;

import com.example.bookmyshow.Models.*;
import com.example.bookmyshow.Repository.BookingRepository;
import com.example.bookmyshow.Repository.ShowRepository;
import com.example.bookmyshow.Repository.ShowSeatRepository;
import com.example.bookmyshow.Repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookingService {
     private final UserRepository userRepository;
     private final ShowRepository showRepository;
     private final ShowSeatRepository showSeatRepository;
     private final BookingRepository bookingRepository;
     public BookingService(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository, BookingRepository bookingRepository) {
         this.userRepository = userRepository;
         this.showRepository = showRepository;
         this.showSeatRepository = showSeatRepository;
         this.bookingRepository = bookingRepository;
     }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(Long showId, Long userId, List<Long> showSetId){
        //get show from showId
        Show show = showRepository.findById(showId).get();
        // get user form UserId
        User user=userRepository.findById(userId).get();
        // get all ShowSeat from showSeatIds
        List<ShowSeat> showSeatList = new ArrayList<>();
       for(Long id: showSetId){
            showSeatList.add(showSeatRepository.findById(id).get());
        }
       // check if seats are available or not
        for(ShowSeat showSeat: showSeatList){
            if(showSeat.getShowSeatStatus().equals(ShowSeatStatus.BOOKED)
            || showSeat.getShowSeatStatus().equals(ShowSeatStatus.BLOCKED)) throw new RuntimeException("seats are already booked");
        }
        //if seats are available then block the seats
        int total_price=0;
        for(ShowSeat showSeat: showSeatList){
            total_price+=showSeat.getPrice();
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
        }

        // create the Booking
        Booking booking=new Booking();
        booking.setShow(show);
        booking.setUser(user);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShowSeats(showSeatList);
        booking.setBookingId(UUID.randomUUID().toString().toUpperCase());
        booking.setAmount(total_price);
        bookingRepository.save(booking);
        user.getBookings().add(booking);
        return booking;
    }


}
