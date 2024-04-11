package com.hms.hms.User.AllUserMapper;

import com.hms.hms.User.UserDataTransferObject.UserDto;
import com.hms.hms.User.UserEntity.User;

public class UserMapper {
    public static UserDto mapUserToDto(User user) {
        return  new UserDto(
                user.getUserID(),
                user.getFullName(),
                user.getAddress(),
                user.getDob(),
                user.getEmail(),
                user.getGender(),
                user.getNationality(),
                user.getRole(),
                user.getContactNo(),
                user.getPassword()
        );
    }

    public User mapDtoToUser(UserDto userDto) {
        return new User(
                userDto.getUserID(),
                userDto.getFullName(),
                userDto.getAddress(),
                userDto.getDob(),
                userDto.getEmail(),
                userDto.getGender(),
                userDto.getNationality(),
                userDto.getRole(),
                userDto.getContactNo(),
                userDto.getPassword()
        );
    }
}
