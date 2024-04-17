package com.hms.hms.User.AllUserMapper;

import com.hms.hms.User.UserDataTransferObject.WardenDto;
import com.hms.hms.User.UserEntity.Warden;

public class WardenMapper{
    public static WardenDto mapWardenToDto(Warden warden){
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
                warden.getPassword(),
                warden.getLecturePost()

        );
    }
    public static Warden mapDtoToWarden(WardenDto wardenDto){
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
                wardenDto.getPassword(),
                wardenDto.getLecturePost()

        );
    }
}
