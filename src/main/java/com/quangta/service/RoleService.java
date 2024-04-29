package com.quangta.service;

import com.quangta.dto.request.RoleRequest;
import com.quangta.dto.response.RoleResponse;

import java.util.List;

public interface RoleService {

    RoleResponse create(RoleRequest request);

    List<RoleResponse> getAllRoles();

}
