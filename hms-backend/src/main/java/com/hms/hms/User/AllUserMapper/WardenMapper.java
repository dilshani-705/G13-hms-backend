package com.hms.hms.User.AllUserMapper;

import com.hms.hms.User.UserDataTransferObject.WardenDto;
import com.hms.hms.User.UserEntity.Warden;
import org.springframework.security.crypto.password.PasswordEncoder;

public class WardenMapper{
    private PasswordEncoder passwordEncoder;
    public WardenDto mapWardenToDto(Warden warden){
        return new WardenDto(
                warden.getUserID(),
                warden.getFullName(),
                warden.getAddress(),
                warden.getDob(),
                warden.getEmail(),
                warden.getGender(),
                warden.getNationality(),
                warden.getRole(),
                warden.getContactNo(),
               this.passwordEncoder.encode(warden.getPassword()),
                warden.getLecturePost()

        );
    }
    public Warden mapDtoToWarden(WardenDto wardenDto){
        return  new Warden(
                wardenDto.getUserID(),
                wardenDto.getFullName(),
                wardenDto.getAddress(),
                wardenDto.getDob(),
                wardenDto.getEmail(),
                wardenDto.getGender(),
                wardenDto.getNationality(),
                wardenDto.getRole(),
                wardenDto.getContactNo(),
                this.passwordEncoder.encode(wardenDto.getPassword()),
                wardenDto.getLecturePost()

        );
    }
}
