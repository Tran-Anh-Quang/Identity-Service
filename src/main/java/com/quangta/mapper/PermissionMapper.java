package com.quangta.mapper;

import com.quangta.dto.request.PermissionRequest;
import com.quangta.dto.response.PermissionResponse;
import com.quangta.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
