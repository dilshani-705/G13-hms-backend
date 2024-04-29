package com.hms.hms.User.UserService;

import com.hms.hms.Login.LoginDto;
import com.hms.hms.Login.LoginMessage;
import com.hms.hms.User.UserDataTransferObject.UserDto;
import com.hms.hms.User.UserEntity.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<UserDto> getAllUsers();
    Optional<User> getUserById(String userId);

    LoginMessage login(LoginDto loginDto);
    //update user
    UserDto updateUser(String userId,UserDto updatedUser);
    //delete user
    void deleteUser(String userId);
}
