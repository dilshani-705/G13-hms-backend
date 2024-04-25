package com.hms.hms.User.UserService.Impl;

import com.hms.hms.User.AllUserMapper.UserMapper;
import com.hms.hms.User.UserDataTransferObject.UserDto;
import com.hms.hms.User.UserEntity.User;
import com.hms.hms.User.UserRepository.UsersRepo;
import com.hms.hms.User.UserService.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepo usersRepo;
    @Autowired
    public UsersServiceImpl(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
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


}
