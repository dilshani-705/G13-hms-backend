package com.hms.hms.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDto {
    private String code;
    private String message;
    private Object content;
}
