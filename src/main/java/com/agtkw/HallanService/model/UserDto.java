package com.agtkw.HallanService.model;

import com.agtkw.HallanService.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;
    private String email;

    private String password;

    private Set<Role> roles = new HashSet<>();

}
