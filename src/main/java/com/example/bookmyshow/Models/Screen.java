package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Screen extends BaseModel{
    public Screen(String screen_Id,String name,Theatre theatre){
        this.screen_Id = screen_Id;
        this.name = name;
        this.theatre = theatre;
        this.seatList=new ArrayList<>();
    }

    public void addSeat(Seat seat){
        this.seatList.add(seat);
    }
    private String screen_Id;
    private String name;
    @OneToMany
    private List<Seat> seatList;
    @ManyToOne
    private Theatre theatre;

}
