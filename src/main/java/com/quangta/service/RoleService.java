package com.quangta.service;

import java.util.List;

import com.quangta.dto.request.RoleRequest;
import com.quangta.dto.response.RoleResponse;

public interface RoleService {

    RoleResponse create(RoleRequest request);

    List<RoleResponse> getAllRoles();
}
