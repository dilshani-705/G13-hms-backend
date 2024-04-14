package com.hms.hms.User.UserController;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserDataTransferObject.DeanDto;
import com.hms.hms.User.UserService.AdminService;
import com.hms.hms.User.UserService.DeanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/deans")
public class DeanController {
    private DeanService deanService;
    //Add an admin
    @PostMapping
    public ResponseEntity<DeanDto> createDean(@RequestBody DeanDto deanDto){
        DeanDto savedDean=deanService.createDean(deanDto);
        return new ResponseEntity<>(savedDean, HttpStatus.CREATED);

    }
}
