package com.quangta.service.impl;

import java.util.List;

import com.quangta.dto.request.PermissionRequest;
import com.quangta.dto.response.PermissionResponse;
import com.quangta.entity.Permission;
import com.quangta.mapper.PermissionMapper;
import com.quangta.repository.PermissionRepository;
import com.quangta.service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionServiceImpl implements PermissionService {

    PermissionRepository permissionRepository;

    PermissionMapper permissionMapper;

    @Override
    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);

        return permissionMapper.toPermissionResponse(permission);
    }

    @Override
    public List<PermissionResponse> getAllPermissions() {
        return permissionRepository.findAll().stream()
                .map(permissionMapper::toPermissionResponse)
                .toList();
    }

    @Override
    public void deletePermission(String permissionId) {
        permissionRepository.deleteById(permissionId);
    }
}
