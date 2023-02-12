package com.agtkw.HallanService.service.impl;

import com.agtkw.HallanService.model.RoleDto;
import com.agtkw.HallanService.repository.RoleRepository;
import com.agtkw.HallanService.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository repository;

    @Override
    public List<RoleDto> roles() {
        return repository.findAll(Pageable.unpaged()).map(RoleDto::new)
                .getContent();
    }
}
