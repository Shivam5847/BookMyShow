package com.example.bookmyshow.EventListner;

import com.example.bookmyshow.Event.BookingEvent;
import com.example.bookmyshow.Models.*;
import com.example.bookmyshow.Repository.BookingRepository;
import com.example.bookmyshow.Repository.ShowSeatRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ReverseBooking {
     private BookingRepository bookingRepository;
     private ShowSeatRepository showSeatRepository;
     public ReverseBooking(BookingRepository bookingRepository, ShowSeatRepository showSeatRepository) {
         this.bookingRepository = bookingRepository;
         this.showSeatRepository = showSeatRepository;
     }

     @KafkaListener(topics="reverse-booking",groupId = "booking-group")
     public void reversebooking(BookingEvent bookingEvent){
          System.out.println(" reverse booking me hien");
        //  List<ShowSeat> showSeatList=bookingRepository.findAllByShowSeatsById(bookingEvent.getId());
          Booking booking=bookingRepository.findBookingById(bookingEvent.getId());
          List<ShowSeat> showSeatList=booking.getShowSeats();
          System.out.println("aa gye");
          for(ShowSeat showSeat:showSeatList){
               showSeat.setShowSeatStatus(ShowSeatStatus.EMPTY);
               showSeatRepository.save(showSeat);
          }
          System.out.println("empty krdi");
          booking.setBookingStatus(BookingStatus.CANCELLED);
          bookingRepository.save(booking);
          System.out.println("booking cancelled");
     }

     @KafkaListener(topics="demo",groupId = "booking-group")
     public void Demo(String message){
          System.out.println(message);
          System.out.println("event aa gya");
     }
}
