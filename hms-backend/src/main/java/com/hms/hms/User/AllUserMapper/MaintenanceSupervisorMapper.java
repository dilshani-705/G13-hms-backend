package com.hms.hms.User.AllUserMapper;

import com.hms.hms.User.UserDataTransferObject.MaintenanceSupervisorDto;
import com.hms.hms.User.UserEntity.MaintenanceSupervisor;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MaintenanceSupervisorMapper {
    private PasswordEncoder passwordEncoder;

    public MaintenanceSupervisorMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public MaintenanceSupervisorDto mapMaintenanceSupervisorToDto(MaintenanceSupervisor maintenanceSupervisor) {
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
                this.passwordEncoder.encode(maintenanceSupervisor.getPassword())

        );
    }

    public MaintenanceSupervisor mapDtoToMaintenanceSupervisor(MaintenanceSupervisorDto maintenanceSupervisorDto) {
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
               this.passwordEncoder.encode(maintenanceSupervisorDto.getPassword())

        );
    }
}
