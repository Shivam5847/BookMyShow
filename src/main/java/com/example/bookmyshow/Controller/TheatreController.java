package com.example.bookmyshow.Controller;

import com.example.bookmyshow.DTO.ScreenAddRequestDTO;
import com.example.bookmyshow.DTO.SeatAddRequestDTO;
import com.example.bookmyshow.DTO.TheatreAddRequestDTO;
import com.example.bookmyshow.Models.Screen;
import com.example.bookmyshow.Models.Seat;
import com.example.bookmyshow.Models.Theatre;
import com.example.bookmyshow.Repository.ScreenRepository;
import com.example.bookmyshow.Repository.TheatreRepository;
import com.example.bookmyshow.Service.TheatreService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
        private final TheatreService theatreService;
        private final TheatreRepository theatreRepository;
        private final ScreenRepository screenRepository;
        public TheatreController(TheatreService theatreService, TheatreRepository theatreRepository, ScreenRepository screenRepository) {
            this.theatreService = theatreService;
            this.theatreRepository = theatreRepository;
            this.screenRepository = screenRepository;
        }

         @PostMapping("/add")
         public Theatre addTheatre(@RequestBody TheatreAddRequestDTO theatreAddRequestDTO) {
                  return theatreService.addTheatre(theatreAddRequestDTO.getTheatre_name());
        }
        @PostMapping("/addScreen")
        public Screen addScreen(@RequestBody ScreenAddRequestDTO screenAddRequestDTO){
            Optional<Theatre> optionalTheatre=theatreRepository.findById(screenAddRequestDTO.getTheatreId());
            if(!optionalTheatre.isPresent()){
                throw new RuntimeException();
            }
            return theatreService.addScreen(optionalTheatre.get(),screenAddRequestDTO.getScreen_name());
        }

        @PostMapping("/addSeat")
        public Seat adddSeat(@RequestBody SeatAddRequestDTO seatAddRequestDTO){
            Optional<Screen> screen=screenRepository.findById(seatAddRequestDTO.getScreenId());
            return theatreService.addSeat(seatAddRequestDTO.getSeatNumber(), seatAddRequestDTO.getSeatType(), screen.get());
        }
}
