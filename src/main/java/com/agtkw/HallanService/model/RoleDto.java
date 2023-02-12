package com.agtkw.HallanService.model;

import com.agtkw.HallanService.entity.Role;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto implements Serializable {

    @NonNull
    private long id;
    @NonNull
    private String roleName;

    public RoleDto(Role role) {
        this. id = role.getId();
        this.roleName = role.getRoleName();
    }
}
