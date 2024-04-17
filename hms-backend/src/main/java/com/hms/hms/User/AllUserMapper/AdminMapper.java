package com.hms.hms.User.AllUserMapper;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserEntity.Admin;

public class AdminMapper {
    public static AdminDto mapAdminToDto(Admin admin) {
        return  new AdminDto(
                admin.getUserID(),
                admin.getFullName(),
                admin.getAddress(),
                admin.getDob(),
                admin.getEmail(),
                admin.getGender(),
                admin.getNationality(),
                admin.getRole(),
                admin.getContactNo(),
                admin.getPassword()
        );
    }

    public static Admin mapDtoToAdmin(AdminDto adminDto) {
        return new Admin(
                adminDto.getUserID(),
                adminDto.getFullName(),
                adminDto.getAddress(),
                adminDto.getDob(),
                adminDto.getEmail(),
                adminDto.getGender(),
                adminDto.getNationality(),
                adminDto.getRole(),
                adminDto.getContactNo(),
                adminDto.getPassword()

        );
    }
}
