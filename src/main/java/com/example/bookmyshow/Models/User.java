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
@Entity(name = "users")
@NoArgsConstructor
public class User extends BaseModel{
    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password= password;
        this.bookings=new ArrayList<>();
    }
    private String name;
    private String email;
    private String password;
    @OneToMany
    private List<Booking> bookings;
}
