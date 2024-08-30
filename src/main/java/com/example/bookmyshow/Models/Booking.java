package com.example.bookmyshow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    private String bookingId;
    @ManyToOne
    private User user;
    private int amount;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<ShowSeat> showSeats;
    @ManyToOne
    private Show show;
}
