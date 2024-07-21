package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
@Entity(name = "shows")
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Screen screen;
    private Date startTime;
    private int duration;
}
