package com.hms.hms.Fines.service;

import com.hms.hms.Fines.Dto.FinesDto;

import java.util.List;

public interface FinesService {
    FinesDto createFines(FinesDto finesDto);
    List<FinesDto> getAllFines();
    FinesDto updateFines(Long finesId, FinesDto updateFines);
    void deleteFines (Long finesId);
    List<FinesDto> searchFinesByTgNumber(String tgNumber);
    List<FinesDto> filterFinesByStatus(String status);
    List<FinesDto> filterFinesByNullStatus();

}
