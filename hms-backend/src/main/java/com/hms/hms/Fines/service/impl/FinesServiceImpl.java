package com.hms.hms.Fines.service.impl;

import com.hms.hms.Fines.Dto.FinesDto;
import com.hms.hms.Fines.entity.Fines;
import com.hms.hms.Fines.mapper.FinesMapper;
import com.hms.hms.Fines.repository.FinesRepository;
import com.hms.hms.Fines.service.FinesService;
import com.hms.hms.Fines.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FinesServiceImpl implements FinesService {
    private final FinesRepository finesRepository;

    @Override
    @Transactional
    public FinesDto createFines(FinesDto finesDto) {
        Fines fines = FinesMapper.mapToFines(finesDto);
        Fines savedFines = finesRepository.save(fines);
        return FinesMapper.mapToFinesDto(savedFines);
    }

    @Override
    public List<FinesDto> getAllFines() {
        List<Fines> fines = finesRepository.findAll();
        return fines.stream().map(FinesMapper::mapToFinesDto).collect(Collectors.toList());
    }
    @Override
    public FinesDto updateFines(Long finesId, FinesDto updateFines) {

        Fines fines = finesRepository.findById(finesId).orElseThrow(
                ()-> new ResourceNotFoundException("fines is not exists with given id:" + finesId)
        );

        fines.setStatus(updateFines.getStatus());

        Fines updateFinesObj = finesRepository.save(fines);

        return FinesMapper.mapToFinesDto(updateFinesObj);
    }

    @Override
    public void deleteFines(Long finesId) {
        Fines fines = finesRepository.findById(finesId).orElseThrow(
                () -> new ResourceNotFoundException("Fines is not exists with given id:" + finesId)
        );
        finesRepository.deleteById(finesId);
    }

    @Override
    public List<FinesDto> searchFinesByTgNumber(String tgNumber) {
        List<Fines> fines = finesRepository.findByTgNumberContainingIgnoreCase(tgNumber);
        return fines.stream().map(FinesMapper::mapToFinesDto).collect(Collectors.toList());
    }

    @Override
    public List<FinesDto> filterFinesByStatus(String status) {
        List<Fines> fines = finesRepository.findByStatus(status);
        return fines.stream().map(FinesMapper::mapToFinesDto).collect(Collectors.toList());
    }

    @Override
    public List<FinesDto> filterFinesByNullStatus() {
        List<Fines> fines = finesRepository.findByStatusIsNull();
        return fines.stream().map(FinesMapper::mapToFinesDto).collect(Collectors.toList());
    }
}

