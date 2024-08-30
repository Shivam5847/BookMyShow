package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ShowSeat extends BaseModel{
    public ShowSeat(Show show,Seat seat,int price) {
        this.show = show;
        this.seat = seat;
        this.price=price;
        this.showSeatStatus=ShowSeatStatus.EMPTY;
        this.blockedAt=null;
    }
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
    private int price;
    private Date blockedAt;
}
