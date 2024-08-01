package com.example.bookmyshow.Controller;

import com.example.bookmyshow.DTO.RequestDto.BookingRequestDto;
import com.example.bookmyshow.Models.ShowSeat;
import com.example.bookmyshow.Models.ShowSeatStatus;
import com.example.bookmyshow.Repository.ShowSeatRepository;
import com.example.bookmyshow.Service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bms")
public class BookingController {
    private final BookingService bookingService;
    private final ShowSeatRepository showSeatRepository;
    public BookingController(BookingService bookingService, ShowSeatRepository showSeatRepository) {
        this.bookingService = bookingService;
        this.showSeatRepository = showSeatRepository;
    }
    @RequestMapping("/makebooking")
    public String createBooking(@RequestBody BookingRequestDto bookingRequestDto){
        String bookingId=bookingService.createBooking(bookingRequestDto.getShowId(),bookingRequestDto.getUserId(),
                bookingRequestDto.getShowSeatId());
        return bookingId;
    }

    @PutMapping("/change/{id}")
    public String change(@PathVariable("id") Long id){
          ShowSeat showSeat=showSeatRepository.findById(id).get();
          showSeat.setShowSeatStatus(ShowSeatStatus.EMPTY);
          showSeatRepository.save(showSeat);
          return "done";
    }
}
