package com.example.demo.controller;


import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/getusers")
    public List<UserDto> getUsers() {
        return userService.getAllUsers();
    }

   @PostMapping("/adduser")
    public UserDto saveuser(@RequestBody UserDto userDto){
        return userService.saveuser(userDto);
   }

   @PutMapping("/updateuser")
    public UserDto updateuser(@RequestBody UserDto userDto){
        return userService.updateuser(userDto);
   }

   @DeleteMapping("/deleteuser")
    public String deleteuser(@RequestBody UserDto userDto){
        return userService.deleteuser(userDto);
   }

    @GetMapping("/user/{userId}")
        public UserDto getuserbyid(@PathVariable Integer userId){
        return userService.getuserbyid(userId);
    }





}
