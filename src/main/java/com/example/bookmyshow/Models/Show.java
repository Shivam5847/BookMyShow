package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
@Entity(name = "shows")
@AllArgsConstructor
@NoArgsConstructor
public class Show extends BaseModel{
    private String show_Id;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Screen screen;
    private Date startTime;
    private int duration;
}
