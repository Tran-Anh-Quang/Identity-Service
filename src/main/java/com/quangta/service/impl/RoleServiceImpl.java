package com.quangta.service.impl;

import java.util.HashSet;
import java.util.List;

import com.quangta.dto.request.RoleRequest;
import com.quangta.dto.response.RoleResponse;
import com.quangta.mapper.RoleMapper;
import com.quangta.repository.PermissionRepository;
import com.quangta.repository.RoleRepository;
import com.quangta.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleServiceImpl implements RoleService {

    RoleRepository roleRepository;

    PermissionRepository permissionRepository;

    RoleMapper roleMapper;

    @Override
    public RoleResponse create(RoleRequest request) {
        var role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    @Override
    public List<RoleResponse> getAllRoles() {
        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }
}
