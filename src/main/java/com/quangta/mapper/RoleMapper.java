package com.quangta.mapper;

import com.quangta.dto.request.RoleRequest;
import com.quangta.dto.response.RoleResponse;
import com.quangta.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
