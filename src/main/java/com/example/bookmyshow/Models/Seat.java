package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Seat extends BaseModel{
    private int seatNumber;
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;


}
