package com.hms.hms.service.impl;

import com.hms.hms.Dto.FeeDto;
import com.hms.hms.entity.Fee;
import com.hms.hms.mapper.FeeMapper;
import com.hms.hms.repository.FeeRepository;
import com.hms.hms.service.FeeService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Repository
public class FeeServiceImpl implements FeeService {

    private final FeeRepository feeRepository;

    public FeeServiceImpl(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }

    @Override
    public List<FeeDto> getAllFee() {
        List<Fee> fees = feeRepository.findAll();
        if (fees == null || fees.isEmpty()) {
            // You can choose to throw an exception or return an empty list based on your requirements
            // throw new RuntimeException("No fees found");
            return List.of(); // Empty list
        }
        // Use method reference instead of lambda expression
        return fees.stream().map(FeeMapper::mapToFeeDto).collect(Collectors.toList());
    }
}
