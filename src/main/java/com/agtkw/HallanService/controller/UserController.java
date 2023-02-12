package com.agtkw.HallanService.controller;

import com.agtkw.HallanService.exception.ResourceNotFoundException;
import com.agtkw.HallanService.model.UserDto;
import com.agtkw.HallanService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping(value = "/user", consumes = "application/json")
    private ResponseEntity<UserDto> create(@RequestBody UserDto user) {
        UserDto userDto = service.create(user);
        if (userDto != null) {
            return new ResponseEntity<>(userDto, HttpStatus.CREATED);
        }
        return new ResponseEntity
                (new ResourceNotFoundException("Something went wrong"), HttpStatus.INTERNAL_SERVER_ERROR);


    }
}
