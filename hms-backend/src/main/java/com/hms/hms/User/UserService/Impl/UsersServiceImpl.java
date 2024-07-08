package com.hms.hms.User.UserService.Impl;

import com.hms.hms.Login.LoginDto;
import com.hms.hms.Login.LoginMessage;
import com.hms.hms.User.AllUserMapper.UserMapper;
import com.hms.hms.User.UserDataTransferObject.UserDto;
import com.hms.hms.User.UserEntity.User;
import com.hms.hms.User.UserRepository.UsersRepo;
import com.hms.hms.User.UserService.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepo usersRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UsersServiceImpl(UsersRepo usersRepo, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.usersRepo = usersRepo;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
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
                msg = "PasswordDto is incorrect";
                return new LoginMessage(msg, false);
            }
        } else {
            msg = "User not found";
            return new LoginMessage(msg, false);
        }
    }

    @Override
    public UserDto updateUser(String userId, UserDto updatedUser) {
        User user=usersRepo.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId));
        user.setFullName(updatedUser.getFullName());
        user.setAddress(updatedUser.getAddress());
        user.setDob(updatedUser.getDob());
        user.setEmail(updatedUser.getEmail());
        user.setGender(updatedUser.getGender());
        user.setNationality(updatedUser.getNationality());
        user.setRole(updatedUser.getRole());
        user.setContactNo(updatedUser.getContactNo());
        if(updatedUser.getPassword()!=null)
            user.setPassword(updatedUser.getPassword(),passwordEncoder);
        usersRepo.save(user);
        return userMapper.mapUserToDto(user);
    }

    @Override
    public boolean changePassword(String userId, String currentPassword, String newPassword) {
        User user = usersRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
            return false;
        }
        user.setPassword(newPassword, passwordEncoder);
        usersRepo.save(user);
        return true;
    }

    @Override
    public void deleteUser(String userId) {
        Optional<User> user = usersRepo.findById(userId);
        if(user.isPresent()){
            usersRepo.delete(user.get());
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found with ID: " + userId);
        }
    }

}
