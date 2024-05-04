package com.hms.hms.User.AllUserMapper;

import com.hms.hms.User.UserDataTransferObject.UserDto;
import com.hms.hms.User.UserEntity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {
    private PasswordEncoder passwordEncoder;

    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto mapUserToDto(User user) {
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
                user.getPassword()!=null ? this.passwordEncoder.encode(user.getPassword()) : null
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
                userDto.getPassword()!=null ? this.passwordEncoder.encode(userDto.getPassword()) : null
        );
    }
}
