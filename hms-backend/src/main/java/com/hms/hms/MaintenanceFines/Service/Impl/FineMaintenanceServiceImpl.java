package com.hms.hms.MaintenanceFines.Service.Impl;

import com.hms.hms.MaintenanceFines.DTO.FineMaintenanceDTO;
import com.hms.hms.MaintenanceFines.Repository.FineMaintenanceRepository;
import com.hms.hms.MaintenanceFines.Repository.RoomMaintenanceRepository;
import com.hms.hms.MaintenanceFines.Service.FineMaintenanceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FineMaintenanceServiceImpl implements FineMaintenanceServiceInterface {
    @Autowired
    private FineMaintenanceRepository fineMaintenanceRepository;

    @Override
    public List<FineMaintenanceDTO> getFinesByStudentId(String studentId) {
        return fineMaintenanceRepository.findFinesByStudentId(studentId);
    }

}
