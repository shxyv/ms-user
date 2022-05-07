package com.atl.msuser.model.dto;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class ExceptionDto {
    private String code;
    private String message;
}
