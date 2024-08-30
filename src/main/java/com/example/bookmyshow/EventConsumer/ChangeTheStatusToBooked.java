package com.example.bookmyshow.EventConsumer;

import com.example.bookmyshow.Event.BookingEvent;
import com.example.bookmyshow.Models.Booking;
import com.example.bookmyshow.Models.BookingStatus;
import com.example.bookmyshow.Models.ShowSeat;
import com.example.bookmyshow.Models.ShowSeatStatus;
import com.example.bookmyshow.Repository.BookingRepository;
import com.example.bookmyshow.Repository.ShowSeatRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ChangeTheStatusToBooked {
    private final BookingRepository bookingRepository;
    private final ShowSeatRepository showSeatRepository;
    public ChangeTheStatusToBooked(KafkaTemplate<String,BookingEvent> kafkaTemplate, BookingRepository bookingRepository, ShowSeatRepository showSeatRepository) {
        this.bookingRepository = bookingRepository;
        this.showSeatRepository = showSeatRepository;
    }
    @KafkaListener(topics = "change-status-to-book",groupId = "booking-group")
    public String changeStatusToBooked(BookingEvent bookingEvent){
        System.out.println("got the change status event");
            String bookingId = bookingEvent.getBookingId();
            Booking booking=bookingRepository.findByBookingId(bookingId);
            List<ShowSeat> showSeatList=booking.getShowSeats();

            for(ShowSeat showSeat:showSeatList){
                showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
                showSeatRepository.save(showSeat);
            }
            booking.setBookingStatus(BookingStatus.CONFIRMED);
            bookingRepository.save(booking);
        System.out.println("status changed");
            return "changed status to booked";
    }
}
