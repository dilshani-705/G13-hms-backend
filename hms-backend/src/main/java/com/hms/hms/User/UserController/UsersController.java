package com.hms.hms.User.UserController;

import com.hms.hms.ChangePassword.PasswordDto;
import com.hms.hms.Login.LoginDto;
import com.hms.hms.Login.LoginMessage;
import com.hms.hms.User.UserDataTransferObject.UserDto;
import com.hms.hms.User.UserEntity.User;
import com.hms.hms.User.UserService.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        LoginMessage loginMessage = usersService.login(loginDto);
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
    // Update user by ID
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") String user_id, @RequestBody UserDto userDto) {
        UserDto updatedUser = usersService.updateUser(user_id, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @PutMapping("/{userId}/changePassword")
    public ResponseEntity<?> changePassword(@PathVariable("userId") String userId, @RequestBody PasswordDto passwordDto) {
        try {
            boolean isUpdated = usersService.changePassword(userId, passwordDto.getCurrentPassword(), passwordDto.getNewPassword());
            if (isUpdated) {
                return ResponseEntity.ok("Password updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update password");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

    // Delete user by ID
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") String user_id) {
        usersService.deleteUser(user_id);
        return ResponseEntity.ok("User deleted successfully");
    }


}
