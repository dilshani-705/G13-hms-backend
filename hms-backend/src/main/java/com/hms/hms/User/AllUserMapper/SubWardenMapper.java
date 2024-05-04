package com.hms.hms.User.AllUserMapper;

import com.hms.hms.User.UserDataTransferObject.SubWardenDto;
import com.hms.hms.User.UserEntity.SubWarden;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SubWardenMapper{
    private PasswordEncoder passwordEncoder;

    public SubWardenMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public SubWardenDto mapSubWardenToDto(SubWarden subwarden){
        return new SubWardenDto(
                subwarden.getUserID(),
                subwarden.getFullName(),
                subwarden.getAddress(),
                subwarden.getDob(),
                subwarden.getEmail(),
                subwarden.getGender(),
                subwarden.getNationality(),
                subwarden.getRole(),
                subwarden.getContactNo(),
                this.passwordEncoder.encode(subwarden.getPassword()),
                subwarden.getDateOfEmployment()

        );
    }
    public SubWarden mapDtoToSubWarden(SubWardenDto subWardenDto){
        return  new SubWarden(
                subWardenDto.getUserID(),
                subWardenDto.getFullName(),
                subWardenDto.getAddress(),
                subWardenDto.getDob(),
                subWardenDto.getEmail(),
                subWardenDto.getGender(),
                subWardenDto.getNationality(),
                subWardenDto.getRole(),
                subWardenDto.getContactNo(),
                this.passwordEncoder.encode(subWardenDto.getPassword()),
                subWardenDto.getDateOfEmployment()

        );
    }
}