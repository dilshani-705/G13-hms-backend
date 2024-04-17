package com.hms.hms.User.AllUserMapper;

import com.hms.hms.User.UserDataTransferObject.SubWardenDto;
import com.hms.hms.User.UserEntity.SubWarden;

public class SubWardenMapper{
    public static SubWardenDto mapSubWardenToDto(SubWarden subwarden){
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
                subwarden.getPassword(),
                subwarden.getDateOfEmployment()

        );
    }
    public static SubWarden mapDtoToSubWarden(SubWardenDto subWardenDto){
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
                subWardenDto.getPassword(),
                subWardenDto.getDateOfEmployment()

        );
    }
}