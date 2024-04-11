package com.hms.hms.User.UserService;


import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserDataTransferObject.StudentDto;
import com.hms.hms.User.UserEntity.Admin;

import java.util.List;
public interface AdminService {
    AdminDto createAdmin(AdminDto adminDto);
    AdminDto getAdminById(String userId);
    List<AdminDto>getAllAdmins();
    AdminDto updatedAdmin(String userId, AdminDto updatedAdmin);
    void deleteAdmin(String userId);

}
