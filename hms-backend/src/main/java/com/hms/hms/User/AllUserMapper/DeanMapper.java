package com.hms.hms.User.AllUserMapper;

import com.hms.hms.User.UserDataTransferObject.DeanDto;
import com.hms.hms.User.UserEntity.Dean;
import org.springframework.security.crypto.password.PasswordEncoder;

public class DeanMapper {
    private PasswordEncoder passwordEncoder;

    public DeanMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public DeanDto mapDeanToDto(Dean dean) {
        return  new DeanDto(
                dean.getUserID(),
                dean.getFullName(),
                dean.getAddress(),
                dean.getDob(),
                dean.getEmail(),
                dean.getGender(),
                dean.getNationality(),
                dean.getRole(),
                dean.getContactNo(),
               dean.getPassword()!=null ? this.passwordEncoder.encode(dean.getPassword()) : null

        );
    }

    public Dean mapDtoToDean(DeanDto deanDto) {
        return new Dean(
                deanDto.getUserID(),
                deanDto.getFullName(),
                deanDto.getAddress(),
                deanDto.getDob(),
                deanDto.getEmail(),
                deanDto.getGender(),
                deanDto.getNationality(),
                deanDto.getRole(),
                deanDto.getContactNo(),
                deanDto.getPassword()!=null ? this.passwordEncoder.encode(deanDto.getPassword()) : null

        );
    }
}
