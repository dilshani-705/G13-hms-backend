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
    private  final PasswordEncoder passwordEncoder;
    @Autowired
    public UsersServiceImpl(UsersRepo usersRepo, PasswordEncoder passwordEncoder, PasswordEncoder passwordEncoder1) {
        this.usersRepo = usersRepo;
        this.passwordEncoder = passwordEncoder1;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users=usersRepo.findAll();
        return users.stream().map((user1 -> UserMapper.mapUserToDto(user1))).collect(Collectors.toList());
    }

    @Override
    public Optional<User> getUserById(String userId) {
        return usersRepo.findById(userId);
    }

    @Override
    public LoginMessage loginUser(LoginDto loginDto) {
        String msg="" ;
        User user=usersRepo.findUserById(loginDto.getUserID());
        if(user!=null){
            String password=loginDto.getPassword();
            String encodedPassword=user.getPassword();

            boolean isPwdRight=passwordEncoder.matches(password,encodedPassword);

            if(isPwdRight){
                Optional<User>user1=usersRepo.findOneByIdAndPassword(loginDto.getUserID(),encodedPassword);
                if(user1.isPresent()){
                    return new LoginMessage("Login Success",true);
                }else {
                    return new LoginMessage("Login Failed",false);
                }
            }else {
                return new LoginMessage("Password not match",false);
            }
        }else {
            return new LoginMessage("User Id not exits",false);
        }
    }


}
