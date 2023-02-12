package com.agtkw.HallanService.controller;

import com.agtkw.HallanService.exception.ResourceNotFoundException;
import com.agtkw.HallanService.model.RoleDto;
import com.agtkw.HallanService.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping(value = "/all")
    private ResponseEntity<List<RoleDto>> roles() {
        List<RoleDto> roles = roleService.roles();
        if (roles.isEmpty()) {
            return new ResponseEntity(new ResourceNotFoundException("No item found"), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<RoleDto>>(roles, HttpStatus.OK);
    }


}
