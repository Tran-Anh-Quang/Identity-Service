package com.quangta.service;

import com.quangta.dto.request.PermissionRequest;
import com.quangta.dto.response.PermissionResponse;

import java.util.List;

public interface PermissionService {

    PermissionResponse create(PermissionRequest request);

    List<PermissionResponse> getAllPermissions();

    void deletePermission(String permissionId);
}
