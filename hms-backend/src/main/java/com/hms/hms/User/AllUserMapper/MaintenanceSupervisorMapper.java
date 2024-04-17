package com.hms.hms.User.AllUserMapper;

import com.hms.hms.User.UserDataTransferObject.MaintenanceSupervisorDto;
import com.hms.hms.User.UserEntity.MaintenanceSupervisor;

public class MaintenanceSupervisorMapper {
    public static MaintenanceSupervisorDto mapMaintenanceSupervisorToDto(MaintenanceSupervisor maintenanceSupervisor) {
        return  new MaintenanceSupervisorDto(
                maintenanceSupervisor.getUserID(),
                maintenanceSupervisor.getFullName(),
                maintenanceSupervisor.getAddress(),
                maintenanceSupervisor.getDob(),
                maintenanceSupervisor.getEmail(),
                maintenanceSupervisor.getGender(),
                maintenanceSupervisor.getNationality(),
                maintenanceSupervisor.getRole(),
                maintenanceSupervisor.getContactNo(),
                maintenanceSupervisor.getPassword()

        );
    }

    public static MaintenanceSupervisor mapDtoToMaintenanceSupervisor(MaintenanceSupervisorDto maintenanceSupervisorDto) {
        return new MaintenanceSupervisor(
                maintenanceSupervisorDto.getUserID(),
                maintenanceSupervisorDto.getFullName(),
                maintenanceSupervisorDto.getAddress(),
                maintenanceSupervisorDto.getDob(),
                maintenanceSupervisorDto.getEmail(),
                maintenanceSupervisorDto.getGender(),
                maintenanceSupervisorDto.getNationality(),
                maintenanceSupervisorDto.getRole(),
                maintenanceSupervisorDto.getContactNo(),
                maintenanceSupervisorDto.getPassword()

        );
    }
}
