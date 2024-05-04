package com.hms.hms.Fees.service.impl;

import com.hms.hms.Fees.Dto.FeeDto;
import com.hms.hms.Fees.entity.Fee;
import com.hms.hms.Fees.mapper.FeeMapper;
import com.hms.hms.Fees.repository.FeeRepository;
import com.hms.hms.Fees.service.FeeService;
import com.hms.hms.Outgoing.Dto.OutgoingDto;
import com.hms.hms.Outgoing.entity.Outgoing;
import com.hms.hms.Outgoing.exception.ResourceNotFoundException;
import com.hms.hms.Outgoing.mapper.OutgoingMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FeeServiceImpl implements FeeService {
    private final FeeRepository feeRepository;

    @Override
    @Transactional
    public FeeDto createFee(FeeDto feeDto) {
        Fee fee = FeeMapper.mapToFee(feeDto);
        Fee savedFee = feeRepository.save(fee);
        return FeeMapper.mapToFeeDto(savedFee);
    }

    @Override
    public List<FeeDto> getAllFee() {
        List<Fee> fees = feeRepository.findAll();
        return fees.stream().map(FeeMapper::mapToFeeDto).collect(Collectors.toList());
    }

//    @Override
//    public FeeDto updateFee(Long feeId, FeeDto updateFee) {
//        Fee fee = feeRepository.findById(feeId)
//                .orElseThrow(() -> new ResourceNotFoundException("Fee is not exists with given id:" + feeId));
//
//        Fee updateFeeObj = feeRepository.save(fee);
//        return FeeMapper.mapToFeeDto(updateFeeObj);
//    }

    @Override
    public FeeDto updateFee(Long feeId, FeeDto updateFee) {

        Fee fee = feeRepository.findById(feeId).orElseThrow(
                ()-> new ResourceNotFoundException("fee is not exists with given id:" + feeId)
        );

        fee.setStatus(updateFee.getStatus());

        Fee updateFeeObj = feeRepository.save(fee);

        return FeeMapper.mapToFeeDto(updateFeeObj);
    }

    @Override
    public void deleteFee(Long feeId) {
        Fee fee = feeRepository.findById(feeId).orElseThrow(
                () -> new ResourceNotFoundException("Fee is not exists with given id:" + feeId)
        );
        feeRepository.deleteById(feeId);
    }
}

