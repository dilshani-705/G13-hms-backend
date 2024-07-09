package com.hms.hms.MaintenanceFines.Service;

import com.hms.hms.MaintenanceFines.DTO.FineMaintenanceDTO;

import java.util.List;

public interface FineMaintenanceServiceInterface {
    List<FineMaintenanceDTO> getFinesByStudentId(String studentId);
}