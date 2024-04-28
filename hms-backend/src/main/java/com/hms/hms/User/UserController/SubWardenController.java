package com.hms.hms.User.UserController;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserDataTransferObject.MaintenanceSupervisorDto;
import com.hms.hms.User.UserDataTransferObject.SubWardenDto;
import com.hms.hms.User.UserService.AdminService;
import com.hms.hms.User.UserService.SubWardenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    }//See all sub wardens
    @GetMapping
    public ResponseEntity<List<SubWardenDto>>getAllSubWardens(){
        List<SubWardenDto>subWarden=subWardenService.getAllSubWardens();
        return ResponseEntity.ok(subWarden);
    }
    @GetMapping("/{subWardenId}")
    public ResponseEntity<SubWardenDto>getSubWardenById(@PathVariable("subWardenId") String subWarden_id){
        SubWardenDto subWardenDto=subWardenService.getSubWardenById(subWarden_id);
        return ResponseEntity.ok(subWardenDto);
    }
    //update a sub warden
    @PutMapping("/{subWardenId}")
    public ResponseEntity<SubWardenDto>updateSubWarden(@PathVariable("subWardenId") String subWarden_id, @RequestBody SubWardenDto updatedSubAWarden){
        SubWardenDto subWardenDto=subWardenService.updatedSubWarden(subWarden_id, updatedSubAWarden);
        return ResponseEntity.ok(subWardenDto);
    }
}
