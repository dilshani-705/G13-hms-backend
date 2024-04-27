package com.hms.hms.User.UserService.Impl;

import com.hms.hms.Login.LoginDto;
import com.hms.hms.Login.LoginMessage;
import com.hms.hms.User.AllUserMapper.UserMapper;
import com.hms.hms.User.UserDataTransferObject.UserDto;
import com.hms.hms.User.UserEntity.User;
import com.hms.hms.User.UserRepository.UsersRepo;
import com.hms.hms.User.UserService.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepo usersRepo;
    private final PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepo usersRepo, PasswordEncoder passwordEncoder) {
        this.usersRepo = usersRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public  List<UserDto> getAllUsers() {

        UserMapper userMapper=new UserMapper(passwordEncoder);
        List<User> users=usersRepo.findAll();
        return users.stream().map(userMapper::mapUserToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<User> getUserById(String userId) {
        return usersRepo.findById(userId);
    }

    @Override
    public LoginMessage login(LoginDto loginDto) {
        String msg = "";
        User user1 = usersRepo.findUserByUserID(loginDto.getUserID());
        if (user1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
            if (isPasswordMatch) {
                Optional<User> user = usersRepo.findUserByUserIDAndPassword(loginDto.getUserID(), encodedPassword);
                if (user.isPresent()) {
                    msg = "Login Successful";
                    return new LoginMessage(msg, true);
                } else {
                    msg = "Login Failed";
                    return new LoginMessage(msg, false);
                }
            } else {
                msg = "Password is incorrect";
                return new LoginMessage(msg, false);
            }
        } else {
            msg = "User not found";
            return new LoginMessage(msg, false);
        }
    }

}
