package com.hms.hms.User.AllUserMapper;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserEntity.Admin;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AdminMapper {
    private PasswordEncoder passwordEncoder;

    public AdminMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public  AdminDto mapAdminToDto(Admin admin) {
        return new AdminDto(
                admin.getUserID(),
                admin.getFullName(),
                admin.getAddress(),
                admin.getDob(),
                admin.getEmail(),
                admin.getGender(),
                admin.getNationality(),
                admin.getRole(),
                admin.getContactNo(),
                admin.getPassword()!= null ? this.passwordEncoder.encode(admin.getPassword()) : null
        );
    }

    public  Admin mapDtoToAdmin(AdminDto adminDto) {
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
               adminDto.getPassword()!= null ? this.passwordEncoder.encode(adminDto.getPassword()) : null

        );
    }
}
