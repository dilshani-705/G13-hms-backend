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
    MaintenanceSupervisorMapper maintenanceSupervisorMapper=new MaintenanceSupervisorMapper();
@Autowired
    public MaintenanceSupervisorServiceImpl(MaintenanceSupervisorRepository maintenanceSupervisorRepository) {
        this.maintenanceSupervisorRepository = maintenanceSupervisorRepository;
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
        maintenanceSupervisor.setPassword(updatedMaintenanceSupervisor.getPassword(),passwordEncoder);

            MaintenanceSupervisor updatedMaintenanceSupervisorObj=maintenanceSupervisorRepository.save(maintenanceSupervisor);

        return maintenanceSupervisorMapper.mapMaintenanceSupervisorToDto(updatedMaintenanceSupervisorObj);
    }

    @Override
    public void deleteMaintenanceSupervisor(String userId) {
        MaintenanceSupervisor maintenanceSupervisor=maintenanceSupervisorRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId));

        maintenanceSupervisorRepository.deleteById(userId);
    }
}
