package com.hms.hms.User.AllUserMapper;

import com.hms.hms.User.UserDataTransferObject.DeanDto;
import com.hms.hms.User.UserEntity.Dean;

public class DeanMapper {
    public static DeanDto mapDeanToDto(Dean dean) {
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
                dean.getPassword()

        );
    }

    public static Dean mapDtoToDean(DeanDto deanDto) {
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
                deanDto.getPassword()

        );
    }
}
