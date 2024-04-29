package com.hms.hms.User.UserService.Impl;

import com.hms.hms.User.AllUserMapper.MaintenanceSupervisorMapper;
import com.hms.hms.User.UserDataTransferObject.MaintenanceSupervisorDto;
import com.hms.hms.User.UserEntity.MaintenanceSupervisor;
import com.hms.hms.User.UserRepository.MaintenanceSupervisorRepository;
import com.hms.hms.User.UserService.MaintenanceSupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class MaintenanceSupervisorServiceImpl implements MaintenanceSupervisorService {
    private final MaintenanceSupervisorRepository maintenanceSupervisorRepository;

    private PasswordEncoder passwordEncoder;
    private final MaintenanceSupervisorMapper maintenanceSupervisorMapper;
@Autowired
    public MaintenanceSupervisorServiceImpl(MaintenanceSupervisorRepository maintenanceSupervisorRepository, PasswordEncoder passwordEncoder, MaintenanceSupervisorMapper maintenanceSupervisorMapper) {
        this.maintenanceSupervisorRepository = maintenanceSupervisorRepository;
    this.passwordEncoder = passwordEncoder;
    this.maintenanceSupervisorMapper = maintenanceSupervisorMapper;
}

    @Override
    public MaintenanceSupervisorDto createMaintenanceSupervisor(MaintenanceSupervisorDto maintenanceSupervisorDto) {
        MaintenanceSupervisor maintenanceSupervisor= maintenanceSupervisorMapper.mapDtoToMaintenanceSupervisor(maintenanceSupervisorDto);
        MaintenanceSupervisor savedMaintenanceSupervisor=maintenanceSupervisorRepository.save(maintenanceSupervisor);
        return maintenanceSupervisorMapper.mapMaintenanceSupervisorToDto(savedMaintenanceSupervisor);
    }

    @Override
    public MaintenanceSupervisorDto getMaintenanceSupervisorById(String maintenanceSupervisor_id) {
        MaintenanceSupervisor maintenanceSupervisor=maintenanceSupervisorRepository.findById(maintenanceSupervisor_id)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+maintenanceSupervisor_id));
        return maintenanceSupervisorMapper.mapMaintenanceSupervisorToDto(maintenanceSupervisor);

    }

    @Override
    public List<MaintenanceSupervisorDto> getAllMaintenanceSupervisors() {
        List<MaintenanceSupervisor> maintenanceSupervisor=maintenanceSupervisorRepository.findAll();
        return maintenanceSupervisor.stream().map(maintenanceSupervisorMapper::mapMaintenanceSupervisorToDto).collect(Collectors.toList());
    }

    @Override
    public MaintenanceSupervisorDto updatedMaintenanceSupervisor(String maintenance_supervisor_id, MaintenanceSupervisorDto updatedMaintenanceSupervisor) {
        MaintenanceSupervisor maintenanceSupervisor=maintenanceSupervisorRepository.findById(maintenance_supervisor_id)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+maintenance_supervisor_id));
        maintenanceSupervisor.setFullName(updatedMaintenanceSupervisor.getFullName());
        maintenanceSupervisor.setAddress(updatedMaintenanceSupervisor.getAddress());
        maintenanceSupervisor.setDob(updatedMaintenanceSupervisor.getDob());
        maintenanceSupervisor.setEmail(updatedMaintenanceSupervisor.getEmail());
        maintenanceSupervisor.setGender(updatedMaintenanceSupervisor.getGender());
        maintenanceSupervisor.setNationality(updatedMaintenanceSupervisor.getNationality());
        maintenanceSupervisor.setRole(updatedMaintenanceSupervisor.getRole());
        maintenanceSupervisor.setContactNo(updatedMaintenanceSupervisor.getContactNo());
        maintenanceSupervisor.setPassword(updatedMaintenanceSupervisor.getPassword(), passwordEncoder);

            if(updatedMaintenanceSupervisor.getPassword()!=null)
                maintenanceSupervisor.setPassword(updatedMaintenanceSupervisor.getPassword(), passwordEncoder);
            maintenanceSupervisorRepository.save(maintenanceSupervisor);
        return maintenanceSupervisorMapper.mapMaintenanceSupervisorToDto(maintenanceSupervisor);
    }

    @Override
    public void deleteMaintenanceSupervisor(String supervisor_id) {
        MaintenanceSupervisor maintenanceSupervisor=maintenanceSupervisorRepository.findById(supervisor_id)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+supervisor_id));

        maintenanceSupervisorRepository.deleteById(supervisor_id);
    }
}
