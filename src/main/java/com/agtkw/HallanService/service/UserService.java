package com.agtkw.HallanService.service;

import com.agtkw.HallanService.model.UserDto;

import java.util.List;

public interface UserService {

    UserDto create(UserDto userDto);
    List<UserDto> allUsers();
    UserDto user(Long userId);
    UserDto updateUser(UserDto userDto);
    String delete(Long userId);
}
