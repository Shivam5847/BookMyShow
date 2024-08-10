package com.example.bookmyshow.Event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingEvent {
    private String type;
    private Long id;
    private String booking_id;
    private int amount;
    private Long showId;
    private Long userId;
}
