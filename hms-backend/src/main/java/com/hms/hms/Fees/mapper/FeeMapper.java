package com.hms.hms.Fees.mapper;

import com.hms.hms.Fees.Dto.FeeDto;
import com.hms.hms.Fees.entity.Fee;

public class FeeMapper {
    public static FeeDto mapToFeeDto(Fee fee){
        return new FeeDto(
                fee.getFeeId(),
                fee.getFullName(),
                fee.getTgNumber(),
                fee.getSubmitDate(),
                fee.getProofImage(),
                fee.getStatus()
        );
    }

    public static Fee mapToFee(FeeDto feeDto){
        return new Fee(
                feeDto.getFeeId(),
                feeDto.getFullName(),
                feeDto.getTgNumber(),
                feeDto.getSubmitDate(),
                feeDto.getProofImage(),
                feeDto.getStatus()
        );
    }

}
