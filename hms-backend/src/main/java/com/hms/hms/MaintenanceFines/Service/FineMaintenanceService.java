package com.hms.hms.MaintenanceFines.Service;

import com.hms.hms.MaintenanceFines.DTO.FineMaintenanceDTO;
import com.hms.hms.MaintenanceFines.Repository.FineMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FineMaintenanceService {
    private final FineMaintenanceRepository fineMaintenanceRepository;

    @Autowired
    public FineMaintenanceService(FineMaintenanceRepository fineMaintenanceRepository) {
        this.fineMaintenanceRepository = fineMaintenanceRepository;
    }

    public List<FineMaintenanceDTO> findByStudentId(String studentId) {
        return fineMaintenanceRepository.findByStudentId(studentId);
    }
}
