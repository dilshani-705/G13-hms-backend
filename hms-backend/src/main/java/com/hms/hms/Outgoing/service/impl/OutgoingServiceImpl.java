package com.hms.hms.Outgoing.service.impl;

import com.hms.hms.Outgoing.Dto.OutgoingDto;
import com.hms.hms.Outgoing.entity.Outgoing;
import com.hms.hms.Outgoing.mapper.OutgoingMapper;
import com.hms.hms.Outgoing.repository.OutgoingRepository;
import com.hms.hms.Outgoing.service.OutgoingService;
import com.hms.hms.mapper.StudentMapper;
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
    @GetMapping
    public List<OutgoingDto> getAllOutgoing() {
        List<Outgoing> outgoings=outgoingRepository.findAll();
        return outgoings.stream().map((outgoing)-> OutgoingMapper.mapToOutgoingDto(outgoing)).collect(Collectors.toList());
    }
}
