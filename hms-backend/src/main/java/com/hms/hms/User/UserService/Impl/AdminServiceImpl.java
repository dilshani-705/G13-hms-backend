package com.hms.hms.User.UserService.Impl;

import com.hms.hms.User.AllUserMapper.AdminMapper;
import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserEntity.Admin;
import com.hms.hms.User.UserRepository.AdminRepository;
import com.hms.hms.User.UserService.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AdminServiceImpl implements AdminService {
     private final AdminRepository adminRepository;

     @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;

    }

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        Admin admin= AdminMapper.mapDtoToAdmin(adminDto);
        Admin savedAdmin=adminRepository.save(admin);
        return AdminMapper.mapAdminToDto(savedAdmin);
    }

    @Override
    public AdminDto getAdminById(String userId) {
        Admin admin=adminRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId));
        return AdminMapper.mapAdminToDto(admin);
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        List<Admin> admin=adminRepository.findAll();
        return admin.stream().map((admin1 -> AdminMapper.mapAdminToDto(admin1))).collect(Collectors.toList());
    }

    @Override
    public AdminDto updatedAdmin(String userId, AdminDto updatedAdmin) {
        Admin admin=adminRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId));
        admin.setFullName(updatedAdmin.getFullName());
        admin.setAddress(updatedAdmin.getAddress());
        admin.setDob(updatedAdmin.getDob());
        admin.setEmail(updatedAdmin.getEmail());
        admin.setGender(updatedAdmin.getGender());
        admin.setNationality(updatedAdmin.getNationality());
        admin.setRole(updatedAdmin.getRole());
        admin.setContactNo(updatedAdmin.getContactNo());
        admin.setPassword(updatedAdmin.getPassword());

        Admin updatedAdminObj=adminRepository.save(admin);

        return AdminMapper.mapAdminToDto(updatedAdminObj);
    }

    @Override
    public void deleteAdmin(String userId) {
        Admin admin=adminRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId));

        adminRepository.deleteById(userId);
    }
}
