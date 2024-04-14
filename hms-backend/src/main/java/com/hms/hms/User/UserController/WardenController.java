package com.hms.hms.User.UserController;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserDataTransferObject.WardenDto;
import com.hms.hms.User.UserService.AdminService;
import com.hms.hms.User.UserService.WardenService;
import lombok.AllArgsConstructor;
import org.hibernate.boot.model.internal.WrappedInferredData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/wardens")
public class WardenController {
    private WardenService wardenService;
    //Add a warden
    @PostMapping
    public ResponseEntity<WardenDto> createWarden(@RequestBody WardenDto wardenDto){
        WardenDto savedWarden=wardenService.createWarden(wardenDto);
        return new ResponseEntity<>(savedWarden, HttpStatus.CREATED);

    }
}
