package com.hms.hms.User.UserService.Impl;

import com.hms.hms.User.AllUserMapper.AdminMapper;
import com.hms.hms.User.AllUserMapper.MaintenanceSupervisorMapper;
import com.hms.hms.User.UserDataTransferObject.MaintenanceSupervisorDto;
import com.hms.hms.User.UserEntity.Admin;
import com.hms.hms.User.UserEntity.MaintenanceSupervisor;
import com.hms.hms.User.UserRepository.MaintenanceSupervisorRepository;
import com.hms.hms.User.UserService.MaintenanceSupervisorService;

import java.util.List;
import java.util.stream.Collectors;

public class MaintenanceSupervisorServiceImpl implements MaintenanceSupervisorService {
    private MaintenanceSupervisorRepository maintenanceSupervisorRepository;
    @Override
    public MaintenanceSupervisorDto createMaintenanceSupervisor(MaintenanceSupervisorDto maintenanceSupervisorDto) {
        MaintenanceSupervisor maintenanceSupervisor= MaintenanceSupervisorMapper.mapDtoToMaintenanceSupervisor(maintenanceSupervisorDto);
        MaintenanceSupervisor savedMaintenanceSupervisor=maintenanceSupervisorRepository.save(maintenanceSupervisor);
        return MaintenanceSupervisorMapper.mapMaintenanceSupervisorToDto(savedMaintenanceSupervisor);
    }

    @Override
    public MaintenanceSupervisorDto getMaintenanceSupervisorById(String userId) {
        MaintenanceSupervisor maintenanceSupervisor=maintenanceSupervisorRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId));
        return MaintenanceSupervisorMapper.mapMaintenanceSupervisorToDto(maintenanceSupervisor);

    }

    @Override
    public List<MaintenanceSupervisorDto> getAllMaintenanceSupervisors() {
        List<MaintenanceSupervisor> maintenanceSupervisor=maintenanceSupervisorRepository.findAll();
        return maintenanceSupervisor.stream().map((maintenanceSupervisor1 -> MaintenanceSupervisorMapper.mapMaintenanceSupervisorToDto(maintenanceSupervisor1))).collect(Collectors.toList());
    }

    @Override
    public MaintenanceSupervisorDto updatedMaintenanceSupervisor(String userId, MaintenanceSupervisorDto updatedMaintenanceSupervisor) {
        MaintenanceSupervisor maintenanceSupervisor=maintenanceSupervisorRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId));
        maintenanceSupervisor.setFullName(updatedMaintenanceSupervisor.getFullName());
        maintenanceSupervisor.setAddress(updatedMaintenanceSupervisor.getAddress());
        maintenanceSupervisor.setDob(updatedMaintenanceSupervisor.getDob());
        maintenanceSupervisor.setEmail(updatedMaintenanceSupervisor.getEmail());
        maintenanceSupervisor.setGender(updatedMaintenanceSupervisor.getGender());
        maintenanceSupervisor.setNationality(updatedMaintenanceSupervisor.getNationality());
        maintenanceSupervisor.setRole(updatedMaintenanceSupervisor.getRole());
        maintenanceSupervisor.setContactNo(updatedMaintenanceSupervisor.getContactNo());
        maintenanceSupervisor.setPassword(updatedMaintenanceSupervisor.getPassword());

            MaintenanceSupervisor updatedMaintenanceSupervisorObj=maintenanceSupervisorRepository.save(maintenanceSupervisor);

        return MaintenanceSupervisorMapper.mapMaintenanceSupervisorToDto(updatedMaintenanceSupervisorObj);
    }

    @Override
    public void deleteMaintenanceSupervisor(String userId) {
        MaintenanceSupervisor maintenanceSupervisor=maintenanceSupervisorRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId));

        maintenanceSupervisorRepository.deleteById(userId);
    }
}
