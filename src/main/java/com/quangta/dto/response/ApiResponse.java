package com.quangta.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // does not get null value field
public class ApiResponse <T> {
    private int code;
    private String message;
    private T result;
}
