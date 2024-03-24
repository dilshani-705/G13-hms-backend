package com.hms.hms.mapper;


import com.hms.hms.Dto.FeeDto;
import com.hms.hms.entity.Fee;

public class FeeMapper {
    public static FeeDto mapToFeeDto(Fee fee){
        return new FeeDto(
                fee.getId(),
                fee.getAcademicYear(),
                fee.getAmount(),
                fee.getDeadline()
        );
    }

    public static Fee mapToFee(FeeDto feeDto){
        return new Fee(
                feeDto.getId(),
                feeDto.getAcademicYear(),
                feeDto.getAmount(),
                feeDto.getDeadline()
        );
    }

}
