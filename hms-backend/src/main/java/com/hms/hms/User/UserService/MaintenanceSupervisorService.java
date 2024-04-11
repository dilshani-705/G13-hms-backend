package com.hms.hms.User.UserService;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserDataTransferObject.MaintenanceSupervisorDto;

import java.util.List;

public interface MaintenanceSupervisorService {
    MaintenanceSupervisorDto createMaintenanceSupervisor(MaintenanceSupervisorDto maintenanceSupervisorDto);
    MaintenanceSupervisorDto getMaintenanceSupervisorById(String userId);
    List<MaintenanceSupervisorDto> getAllMaintenanceSupervisors();
    MaintenanceSupervisorDto updatedMaintenanceSupervisor(String userId, MaintenanceSupervisorDto updatedMaintenanceSupervisor);
    void deleteMaintenanceSupervisor(String userId);

}
