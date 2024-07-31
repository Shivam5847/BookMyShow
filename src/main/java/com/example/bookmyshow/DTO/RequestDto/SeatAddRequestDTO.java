package com.example.bookmyshow.DTO.RequestDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatAddRequestDTO {
    private int seatNumber;
    private String seatType;
    private Long screenId;
}
