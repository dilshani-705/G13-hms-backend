package com.hms.hms.User.UserController;

import com.hms.hms.Login.LoginDto;
import com.hms.hms.Login.LoginMessage;
import com.hms.hms.User.UserDataTransferObject.UserDto;
import com.hms.hms.User.UserEntity.User;
import com.hms.hms.User.UserService.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersController {
    private UsersService usersService;
    @PostMapping("/{login}")
    public ResponseEntity<?>loginUser(@RequestBody LoginDto loginDto){
        LoginMessage loginMessage=usersService.loginUser(loginDto);
        return ResponseEntity.ok(loginMessage);
    }
    //See all users
    @GetMapping
    public ResponseEntity<List<UserDto>>getAllUsers(){
        List<UserDto>users=usersService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    // Get user by ID
    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable("userId") String userId) {
        return usersService.getUserById(userId);
    }

}
