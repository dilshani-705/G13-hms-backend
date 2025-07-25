package com.hms.hms.Outgoing.service.impl;

import com.hms.hms.Fees.Dto.FeeDto;
import com.hms.hms.Fees.entity.Fee;
import com.hms.hms.Fees.mapper.FeeMapper;
import com.hms.hms.Outgoing.Dto.OutgoingDto;
import com.hms.hms.Outgoing.entity.Outgoing;
import com.hms.hms.Outgoing.exception.ResourceNotFoundException;
import com.hms.hms.Outgoing.mapper.OutgoingMapper;
import com.hms.hms.Outgoing.repository.OutgoingRepository;
import com.hms.hms.Outgoing.service.OutgoingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OutgoingServiceImpl implements OutgoingService {

    private OutgoingRepository outgoingRepository;
    @Override
    public OutgoingDto createOutgoing(OutgoingDto outgoingDto) {
        Outgoing outgoing= OutgoingMapper.mapToOutgoing(outgoingDto);
        Outgoing savedOutgoing=outgoingRepository.save(outgoing);
        return OutgoingMapper.mapToOutgoingDto(savedOutgoing);
    }

    @Override
    public List<OutgoingDto> getAllOutgoing() {
        List<Outgoing> outgoings=outgoingRepository.findAll();
        return outgoings.stream().map(OutgoingMapper::mapToOutgoingDto).collect(Collectors.toList());
    }

    @Override
    public OutgoingDto updateOutgoing(Long outgoingId, OutgoingDto updateOutgoing) {

        Outgoing outgoing = outgoingRepository.findById(outgoingId).orElseThrow(
                ()-> new ResourceNotFoundException("Outgoing is not exists with given id:" + outgoingId)
        );

        outgoing.setArrivalDate(updateOutgoing.getArrivalDate());
        outgoing.setArrivalTime(updateOutgoing.getArrivalTime());

        Outgoing updateOutgoingObj = outgoingRepository.save(outgoing);

        return OutgoingMapper.mapToOutgoingDto(updateOutgoingObj);
    }

    // Delete Outgoing by Id
    @Override
    public void deleteOutgoing(Long outgoingId) {
        Outgoing outgoing = outgoingRepository.findById(outgoingId).orElseThrow(
                () -> new ResourceNotFoundException("Outgoing is not exists with given id:" + outgoingId)
        );
        outgoingRepository.deleteById(outgoingId);
    }

    @Override
    public List<OutgoingDto> getOutgoingByType(String selectOutgoingType) {
        List<Outgoing> outgoings = outgoingRepository.findBySelectOutgoingType(selectOutgoingType);
        return outgoings.stream().map(OutgoingMapper::mapToOutgoingDto).collect(Collectors.toList());
    }

    @Override
    public List<OutgoingDto> getOutgoingByHostelType(String selectHostelType) {
        List<Outgoing> outgoings = outgoingRepository.findBySelectHostelType(selectHostelType);
        return outgoings.stream().map(OutgoingMapper::mapToOutgoingDto).collect(Collectors.toList());
    }

    @Override
    public List<OutgoingDto> findOutgoingsWithNullArrivalDate() {
        List<Outgoing> outgoings = outgoingRepository.findByArrivalDateIsNull();
        return outgoings.stream().map(OutgoingMapper::mapToOutgoingDto).collect(Collectors.toList());
    }
}
