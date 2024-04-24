package com.hms.hms.User.UserController;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserService.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedAdmin);

    }
    //See an admin
    @GetMapping("{adminId}")
    public ResponseEntity<AdminDto>getAdminById(@PathVariable("adminId") String admin_id){
        AdminDto adminDto=adminService.getAdminById(admin_id);
        return ResponseEntity.ok(adminDto);
    }
    //See all admins
    @GetMapping
    public ResponseEntity<List<AdminDto>>getAllAdmins(){
        List<AdminDto>admin=adminService.getAllAdmins();
        return ResponseEntity.ok(admin);
    }
    //Update ad admin
    @PutMapping("{adminId}")
    public ResponseEntity<AdminDto>updateAdmin(@PathVariable("adminId")String admin_id,@RequestBody AdminDto updatedAdmin){
        AdminDto adminDto=adminService.updatedAdmin(admin_id,updatedAdmin);
        return  ResponseEntity.ok(adminDto);
    }
    @DeleteMapping("{adminId}")
    public ResponseEntity<String>deleteAdmin(@PathVariable("adminId")String admin_id){
        adminService.deleteAdmin(admin_id);
        return  ResponseEntity.ok("Delete admin successfully");
    }


}

