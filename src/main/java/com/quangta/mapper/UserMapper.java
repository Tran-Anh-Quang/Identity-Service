package com.quangta.mapper;

import com.quangta.dto.request.UserCreationRequest;
import com.quangta.dto.request.UserUpdateRequest;
import com.quangta.dto.response.UserResponse;
import com.quangta.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User createUser(UserCreationRequest request);

//    @Mapping(target = "lastName", ignore = true) // custom response field
    UserResponse mapToUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
