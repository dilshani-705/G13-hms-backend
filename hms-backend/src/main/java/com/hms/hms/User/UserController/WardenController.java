package com.hms.hms.User.UserController;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserDataTransferObject.SubWardenDto;
import com.hms.hms.User.UserDataTransferObject.WardenDto;
import com.hms.hms.User.UserService.AdminService;
import com.hms.hms.User.UserService.WardenService;
import lombok.AllArgsConstructor;
import org.hibernate.boot.model.internal.WrappedInferredData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    //See all wardens
    @GetMapping
    public ResponseEntity<List<WardenDto>>getAllWardens(){
        List<WardenDto>warden=wardenService.getAllWardens();
        return ResponseEntity.ok(warden);
    }
    @GetMapping("/{wardenId}")
    public ResponseEntity<WardenDto>getWardenById(@PathVariable("wardenId") String warden_id){
        WardenDto wardenDto=wardenService.getWardenById(warden_id);
        return ResponseEntity.ok(wardenDto);
    }
}
