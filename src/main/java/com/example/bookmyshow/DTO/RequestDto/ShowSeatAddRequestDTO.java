package com.example.bookmyshow.DTO.RequestDto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ShowSeatAddRequestDTO {
    private Long showId;
    private List<Long> showSeatId;
    private int price;
}
