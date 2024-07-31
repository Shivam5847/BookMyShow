package com.example.bookmyshow.DTO.RequestDto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ShowAddRequestDTO {
    private Long movieId;
    private Long screenId;
    private Date startTime;
    private int duration;
}
