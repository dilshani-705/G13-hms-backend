package com.hms.hms.User.UserController;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserDataTransferObject.UserDto;
import com.hms.hms.User.UserService.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersController {
    private UsersService usersService;
    //See all users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto>users=usersService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
