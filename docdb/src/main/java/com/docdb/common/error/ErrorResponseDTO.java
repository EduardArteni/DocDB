package com.docdb.common.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("error")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public record ErrorResponseDTO(
        Integer status,
        String message,
        List<String> details) {

    public ErrorResponseDTO(Integer status, String message) {
        this(status, message, null);
    }
}
