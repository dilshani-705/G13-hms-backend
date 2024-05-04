package com.hms.hms.Fees.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeeDto {

    private long feeId;

    private String fullName;

    private String tgNumber;

    private String submitDate;

    private byte[] proofImage;

    private String status;

}
