package com.hms.hms.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeeDto {
    private Long id;
    private String academicYear;
    private String amount;
    private String deadline;
}
