package com.hms.hms.User.UserController;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserDataTransferObject.SubWardenDto;
import com.hms.hms.User.UserService.AdminService;
import com.hms.hms.User.UserService.SubWardenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/sub_wardens")
public class SubWardenController {
    private SubWardenService subWardenService;
    //Add a sub warden
    @PostMapping
    public ResponseEntity<SubWardenDto> createSubWarden(@RequestBody SubWardenDto subWardenDto){
        SubWardenDto savedSubWarden=subWardenService.createSubWarden(subWardenDto);
        return new ResponseEntity<>(savedSubWarden, HttpStatus.CREATED);

    }
}
