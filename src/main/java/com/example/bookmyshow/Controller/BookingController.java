package com.example.bookmyshow.Controller;

import com.example.bookmyshow.DTO.RequestDto.BookingEventDto;
import com.example.bookmyshow.DTO.RequestDto.BookingRequestDto;
import com.example.bookmyshow.EventProducer.BookingEventProducer;
import com.example.bookmyshow.Models.Booking;
import com.example.bookmyshow.Models.ShowSeat;
import com.example.bookmyshow.Models.ShowSeatStatus;
import com.example.bookmyshow.Repository.BookingRepository;
import com.example.bookmyshow.Repository.ShowSeatRepository;
import com.example.bookmyshow.Service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bms")
public class BookingController {

    private final BookingService bookingService;
    private final ShowSeatRepository showSeatRepository;
    private final BookingEventProducer bookingEventProducer;
    private final BookingRepository bookingRepository;
    public BookingController(BookingService bookingService, ShowSeatRepository showSeatRepository, BookingEventProducer bookingEventProducer, BookingRepository bookingRepository) {
        this.bookingService = bookingService;
        this.showSeatRepository = showSeatRepository;
        this.bookingEventProducer = bookingEventProducer;
        //this.bookingEventProducer = bookingEventProducer;
        this.bookingRepository = bookingRepository;
    }
    @PostMapping("/createBooking")
    public String createBooking(@RequestBody BookingRequestDto bookingRequestDto) {
        // creating the booking
        Booking booking =bookingService.createBooking(bookingRequestDto.getShowId(),bookingRequestDto.getUserId(), bookingRequestDto.getShowSeatId());
        return booking.getBookingId();
    }
    @PostMapping("/publishBookingEvent")
    public String publishBookingEvent(@RequestBody BookingEventDto bookingEventDto){
           String bookingId = bookingEventDto.getBookingId();
           Booking booking=bookingRepository.findByBookingId(bookingId);
           try{
               System.out.println("hello!");
               bookingEventProducer.publishBookingEvent(booking);
           }
           catch(Exception e){
               return e.getMessage();
           }
           return "Event Successfully Published";
    }
    @PutMapping("/change/{id}")
    public String change(@PathVariable("id") Long id){
          ShowSeat showSeat=showSeatRepository.findById(id).get();
          showSeat.setShowSeatStatus(ShowSeatStatus.EMPTY);
          showSeatRepository.save(showSeat);
          return "done";
    }
}
