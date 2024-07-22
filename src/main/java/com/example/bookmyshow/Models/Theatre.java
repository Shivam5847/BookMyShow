package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
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
public class Theatre extends BaseModel{
    public Theatre(String theatre_Id, String name){
        this.theatre_Id=theatre_Id;
        this.name=name;
        this.shows=new ArrayList<Show>();
    }
    private String theatre_Id;
    private String name;
    @OneToMany
    private List<Show> shows;

}
