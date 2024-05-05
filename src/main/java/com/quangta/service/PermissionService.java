package com.quangta.service;

import java.util.List;

import com.quangta.dto.request.PermissionRequest;
import com.quangta.dto.response.PermissionResponse;

public interface PermissionService {

    PermissionResponse create(PermissionRequest request);

    List<PermissionResponse> getAllPermissions();

    void deletePermission(String permissionId);
}
