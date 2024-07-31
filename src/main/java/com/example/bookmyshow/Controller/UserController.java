package com.example.bookmyshow.Controller;

import com.example.bookmyshow.DTO.RequestDto.UserAddDto;
import com.example.bookmyshow.Models.User;
import com.example.bookmyshow.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bms")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/adduser")
    public User addUser(@RequestBody UserAddDto userAddDto){
      return userService.adduser(userAddDto.getName(), userAddDto.getEmail(), userAddDto.getPassword());
    }
}
