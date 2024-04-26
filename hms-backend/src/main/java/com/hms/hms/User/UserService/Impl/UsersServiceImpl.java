package com.hms.hms.User.UserService.Impl;

import com.hms.hms.Login.LoginDto;
import com.hms.hms.Login.LoginMessage;
import com.hms.hms.User.AllUserMapper.UserMapper;
import com.hms.hms.User.UserDataTransferObject.UserDto;
import com.hms.hms.User.UserEntity.User;
import com.hms.hms.User.UserRepository.UsersRepo;
import com.hms.hms.User.UserService.UsersService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepo usersRepo;
    private PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepo usersRepo, PasswordEncoder passwordEncoder) {
        this.usersRepo = usersRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public  List<UserDto> getAllUsers() {
        List<User> users=usersRepo.findAll();
        UserMapper userMapper=new UserMapper(passwordEncoder);
        return users.stream().map(userMapper::mapUserToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<User> getUserById(String userId) {
        return usersRepo.findById(userId);
    }

    @Override
    public LoginMessage login(LoginDto loginDto) {
        String msg="";
        User user=usersRepo.findUserByUserID(loginDto.getUserID());
        if (user==null){
            msg="User not found";
        }
        else if (passwordEncoder.matches(loginDto.getPassword(),user.getPassword())){
            msg="Login successful";
        }
        else {
            msg="Incorrect password";
        }
        return null;
    }


}
