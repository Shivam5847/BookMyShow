package com.example.bookmyshow.EventProducer;

import com.example.bookmyshow.Event.BookingEvent;
import com.example.bookmyshow.Exception.BookingEventPublishException;
import com.example.bookmyshow.Models.Booking;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookingEventProducer {

    private final KafkaTemplate<String, BookingEvent> kafkaTemplate;

    public BookingEventProducer(KafkaTemplate<String, BookingEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String publishBookingEvent(Booking booking) {
        //Create the BookingEvent
        try{
            System.out.println("inside the booking event");
            BookingEvent bookingEvent=new BookingEvent();
            bookingEvent.setId(booking.getId());
            bookingEvent.setBookingId(booking.getBookingId());
            bookingEvent.setAmount(booking.getAmount());
            bookingEvent.setShowId(booking.getShow().getId());
            bookingEvent.setType("BOOKING-CREATED");
            bookingEvent.setUserId(booking.getUser().getId());
            // Publishing the Event
            kafkaTemplate.send("new-booking",bookingEvent);
            System.out.println("event published");
            return "Event Published";
        }
        catch(Exception e){
                 throw  new BookingEventPublishException("BookingEvent could not be published");
        }
    }
}
