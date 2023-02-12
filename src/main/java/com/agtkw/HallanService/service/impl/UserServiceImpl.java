package com.agtkw.HallanService.service.impl;

import com.agtkw.HallanService.entity.Users;
import com.agtkw.HallanService.exception.ResourceNotFoundException;
import com.agtkw.HallanService.model.UserDto;
import com.agtkw.HallanService.repository.RoleRepository;
import com.agtkw.HallanService.repository.UserRepository;
import com.agtkw.HallanService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDto create(UserDto userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new ResourceNotFoundException("Email id already taken");
        }
        Users user = new Users();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
        if (userDto.getRoles() != null) {
            userDto.getRoles().forEach(role -> {
                switch (role.getRoleName()) {
                    case "BACKOFFICE":
                    case "TECHNICIAN":
                    case "CUSTOMER":
                        roleRepository.findByRoleName(role.getRoleName())
                                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));
                        break;

                    default:
                        roleRepository.findByRoleName(role.getRoleName())
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        break;

                }
            });
            user.setRoles(userDto.getRoles());
        } else {
            throw new ResourceNotFoundException("Role cannot be null");
        }
        Users result = userRepository.save(user);
        userDto.setId(result.getId());
        return userDto;
    }

    @Override
    public List<UserDto> allUsers() {
        return null;
    }

    @Override
    public UserDto user(Long userId) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public String delete(Long userId) {
        return null;
    }
}
