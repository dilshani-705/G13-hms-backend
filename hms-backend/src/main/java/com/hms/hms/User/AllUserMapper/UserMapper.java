package com.hms.hms.User.AllUserMapper;

import com.hms.hms.User.UserDataTransferObject.UserDto;
import com.hms.hms.User.UserEntity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {
    private final PasswordEncoder passwordEncoder;

    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

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
                this.passwordEncoder.encode(user.getPassword())
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
                this.passwordEncoder.encode(userDto.getPassword())
        );
    }
}
