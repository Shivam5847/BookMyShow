package com.example.bookmyshow.DTO.RequestDto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingRequestDto {
    private Long showId;
    private Long userId;
    private List<Long> showSeatId;
}
