package com.hms.hms.User.UserController;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserService.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/admins")
public class AdminController {
    private AdminService adminService;
    //Add an admin
    @PostMapping
    public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto adminDto){
        AdminDto savedAdmin=adminService.createAdmin(adminDto);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);

    }
    //See an admin
    @GetMapping("{userID}")
    public ResponseEntity<AdminDto>getAdminById(@PathVariable("userID") String adminID){
        AdminDto adminDto=adminService.getAdminById(adminID);
        return ResponseEntity.ok(adminDto);
    }
    //See all admins
    @GetMapping
    public ResponseEntity<List<AdminDto>>getAllAdmins(){
        List<AdminDto>admin=adminService.getAllAdmins();
        return ResponseEntity.ok(admin);
    }
    //Update ad admin
    @PutMapping("{userID}")
    public ResponseEntity<AdminDto>updateAdmin(@PathVariable("userID")String adminID,@RequestBody AdminDto updatedAdmin){
        AdminDto adminDto=adminService.updatedAdmin(adminID,updatedAdmin);
        return  ResponseEntity.ok(adminDto);
    }
    public ResponseEntity<String>deleteAdmin(@PathVariable("userID")String adminID){
        adminService.deleteAdmin(adminID);
        return  ResponseEntity.ok("Delete admin successfully");
    }


}

