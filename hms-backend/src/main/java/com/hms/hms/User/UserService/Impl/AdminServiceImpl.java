package com.hms.hms.User.UserService.Impl;

import com.hms.hms.User.AllUserMapper.AdminMapper;
import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserEntity.Admin;
import com.hms.hms.User.UserRepository.AdminRepository;
import com.hms.hms.User.UserService.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AdminServiceImpl implements AdminService {
     private final AdminRepository adminRepository;
    private PasswordEncoder passwordEncoder;
    private final AdminMapper adminMapper;
    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository, PasswordEncoder passwordEncoder, AdminMapper adminMapper) {
        this.adminRepository = adminRepository;
         this.passwordEncoder = passwordEncoder;
        this.adminMapper = adminMapper;
    }

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {

        Admin admin= adminMapper.mapDtoToAdmin(adminDto);
        Admin savedAdmin=adminRepository.save(admin);
        return adminMapper.mapAdminToDto(savedAdmin);
    }

    @Override
    public AdminDto getAdminById(String admin_id) {
        Admin admin=adminRepository.findById(admin_id)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+admin_id));
        return adminMapper.mapAdminToDto(admin);
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        List<Admin> admins=adminRepository.findAll();
        return admins.stream().map(adminMapper::mapAdminToDto).collect(Collectors.toList());
    }


    @Override
    public AdminDto updatedAdmin(String admin_id, AdminDto updatedAdmin) {
        Admin admin=adminRepository.findById(admin_id)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+admin_id));
        admin.setFullName(updatedAdmin.getFullName());
        admin.setAddress(updatedAdmin.getAddress());
        admin.setDob(updatedAdmin.getDob());
        admin.setContactNo(updatedAdmin.getContactNo());
        admin.setEmail(updatedAdmin.getEmail());
        admin.setGender(updatedAdmin.getGender());
        admin.setNationality(updatedAdmin.getNationality());
        admin.setRole(updatedAdmin.getRole());

        if (updatedAdmin.getPassword() != null){
            admin.setPassword(updatedAdmin.getPassword(), passwordEncoder);
        }
        adminRepository.save(admin);
        return adminMapper.mapAdminToDto(admin);
    }


    @Override
    public void deleteAdmin(String admin_id) {
        Admin admin=adminRepository.findById(admin_id)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+admin_id));

        adminRepository.deleteById(admin_id);
    }
}
