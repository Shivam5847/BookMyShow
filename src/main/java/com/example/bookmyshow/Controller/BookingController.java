package com.example.bookmyshow.Controller;

import com.example.bookmyshow.DTO.RequestDto.BookingRequestDto;
import com.example.bookmyshow.Event.BookingEvent;
import com.example.bookmyshow.Models.Booking;
import com.example.bookmyshow.Models.ShowSeat;
import com.example.bookmyshow.Models.ShowSeatStatus;
import com.example.bookmyshow.Repository.ShowSeatRepository;
import com.example.bookmyshow.Service.BookingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bms")
public class BookingController {
    private final BookingService bookingService;
    private final ShowSeatRepository showSeatRepository;
    private KafkaTemplate<String, BookingEvent> kafkaTemplate;
    public BookingController(BookingService bookingService, ShowSeatRepository showSeatRepository, KafkaTemplate<String, BookingEvent> kafkaTemplate) {
        this.bookingService = bookingService;
        this.showSeatRepository = showSeatRepository;
        this.kafkaTemplate = kafkaTemplate;
        //this.objectMapper = objectMapper;
    }
    @PostMapping("/makebooking")
    public String createBooking(@RequestBody BookingRequestDto bookingRequestDto) throws JsonProcessingException {
        Booking booking =bookingService.createBooking(bookingRequestDto.getShowId(),bookingRequestDto.getUserId(),
                bookingRequestDto.getShowSeatId());
        BookingEvent bookingEvent=new BookingEvent();
        bookingEvent.setId(booking.getId());
        bookingEvent.setBooking_id(booking.getBooking_Id());
        bookingEvent.setAmount(20);
        bookingEvent.setShowId(booking.getShow().getId());
        bookingEvent.setType("BOOKING-CREATED");
        bookingEvent.setUserId(booking.getUser().getId());
      //  Message message= (Message) MessageBuilder.withPayload(bookingEvent)
      //          .setHeader(KafkaHeaders.TOPIC,"new-booking").build();
        //kafkaTemplate.send((ProducerRecord<String, BookingEvent>) message);
        kafkaTemplate.send("new-booking",bookingEvent);
        return booking.getBooking_Id();
    }

    @PutMapping("/change/{id}")
    public String change(@PathVariable("id") Long id){
          ShowSeat showSeat=showSeatRepository.findById(id).get();
          showSeat.setShowSeatStatus(ShowSeatStatus.EMPTY);
          showSeatRepository.save(showSeat);
          return "done";
    }

}
