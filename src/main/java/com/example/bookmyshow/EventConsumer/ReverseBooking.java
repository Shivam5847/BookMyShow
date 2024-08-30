package com.example.bookmyshow.EventConsumer;

import com.example.bookmyshow.Event.BookingEvent;
import com.example.bookmyshow.Models.*;
import com.example.bookmyshow.Repository.BookingRepository;
import com.example.bookmyshow.Repository.ShowSeatRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import java.util.List;


public class ReverseBooking {
//     private final BookingRepository bookingRepository;
//     private final ShowSeatRepository showSeatRepository;
//     public ReverseBooking(BookingRepository bookingRepository, ShowSeatRepository showSeatRepository) {
//         this.bookingRepository = bookingRepository;
//         this.showSeatRepository = showSeatRepository;
//     }
//
//     @KafkaListener(topics="reverse-booking",groupId = "booking-group")
//     public void reverseBooking(BookingEvent bookingEvent){
//          System.out.println(" reverse booking me hien");
//         try{
//              Booking booking=bookingRepository.findBookingById(bookingEvent.getId());
//              List<ShowSeat> showSeatList=booking.getShowSeats();
//              System.out.println("aa gye");
//              for(ShowSeat showSeat:showSeatList){
//                   showSeat.setShowSeatStatus(ShowSeatStatus.EMPTY);
//                   showSeatRepository.save(showSeat);
//              }
//              System.out.println("empty kardi hein");
//              booking.setBookingStatus(BookingStatus.FAILED);
//              bookingRepository.save(booking);
//         }
//
//         catch(Exception e){
//              throw new RuntimeException("Seats cannot be emptied try again!!!");
//          }
//     }
//
//     @KafkaListener(topics="demo",groupId = "booking-group")
//     public void Demo(String message){
//          System.out.println(message);
//          System.out.println("event aa gya");
//     }
}
