package com.hms.hms.Fees.service;

import com.hms.hms.Fees.Dto.FeeDto;
import com.hms.hms.Fines.Dto.FinesDto;

import java.util.List;

public interface FeeService {
    FeeDto createFee(FeeDto feeDto);
    List<FeeDto> getAllFee();
    FeeDto updateFee(Long feeId, FeeDto updateFee);
    void deleteFee (Long feeId);
    List<FeeDto> searchFeesByTgNumber(String tgNumber);
    List<FeeDto> filterFeesByStatus(String status);
    List<FeeDto> filterFeesByNullStatus();

}
