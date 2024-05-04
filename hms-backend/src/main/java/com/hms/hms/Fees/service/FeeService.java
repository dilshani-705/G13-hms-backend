package com.hms.hms.Fees.service;

import com.hms.hms.Fees.Dto.FeeDto;

import java.util.List;

public interface FeeService {
    FeeDto createFee(FeeDto feeDto);
    List<FeeDto> getAllFee();
    FeeDto updateFee(Long feeId, FeeDto updateFee);
    void deleteFee (Long feeId);

}
