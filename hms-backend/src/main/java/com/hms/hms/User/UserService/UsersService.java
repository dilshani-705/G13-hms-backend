package com.hms.hms.User.UserService;

import com.hms.hms.User.UserDataTransferObject.UserDto;
import com.hms.hms.User.UserDataTransferObject.WardenDto;
import com.hms.hms.User.UserEntity.User;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();
}
