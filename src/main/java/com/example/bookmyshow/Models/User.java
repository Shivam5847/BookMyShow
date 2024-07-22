package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "users")
public class User extends BaseModel{
    private String Name;
    private String Email;
    private String Password;
    @OneToMany
    private List<Booking> bookings;
}
