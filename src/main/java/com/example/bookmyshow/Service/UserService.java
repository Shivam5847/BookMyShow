package com.example.bookmyshow.Service;

import com.example.bookmyshow.Models.User;
import com.example.bookmyshow.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User adduser(String name,String password,String email){
        Optional<User> optionalUser=userRepository.findByemail(email);
        if(optionalUser.isPresent()){return optionalUser.get();}
        User user=new User(name,password,email);
       return userRepository.save(user);

    }
}
