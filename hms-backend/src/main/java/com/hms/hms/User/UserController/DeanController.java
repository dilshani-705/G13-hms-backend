package com.hms.hms.User.UserController;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserDataTransferObject.DeanDto;
import com.hms.hms.User.UserService.DeanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/deans")
public class DeanController {
    private  DeanService deanService;

    //Add a dean
    @PostMapping
    public ResponseEntity<DeanDto> createDean(@RequestBody DeanDto deanDto){
        DeanDto savedDean=deanService.createDean(deanDto);
        return new ResponseEntity<>(savedDean, HttpStatus.CREATED);

    }
    //See a dean
    @GetMapping("/{deanId}")
    public ResponseEntity<DeanDto>getDeanById(@PathVariable("deanId") String deanId){
        DeanDto deanDto=deanService.getDeanById(deanId);
        return ResponseEntity.ok(deanDto);
    }
    //See all deans
    @GetMapping
    public ResponseEntity<List<DeanDto>>getAllDeans(){
        List<DeanDto>dean=deanService.getAllDeans();
        return ResponseEntity.ok(dean);
    }
    //Update a dean
    @PutMapping("/{deanId}")
    public ResponseEntity<DeanDto>updateDean(@PathVariable("deanId") String dean_Id, @RequestBody DeanDto updatedDean){
        DeanDto deanDto=deanService.updatedDean(dean_Id,updatedDean);
        return ResponseEntity.ok(deanDto);
    }
    //Delete a dean
    @DeleteMapping("/{deanId}")
    public ResponseEntity<String>deleteDean(@PathVariable("deanId") String dean_Id){
        deanService.deleteDean(dean_Id);
        return ResponseEntity.ok("Dean deleted successfully");
    }
}
