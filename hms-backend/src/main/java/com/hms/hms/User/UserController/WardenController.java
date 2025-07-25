package com.hms.hms.User.UserController;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserDataTransferObject.StudentDto;
import com.hms.hms.User.UserDataTransferObject.SubWardenDto;
import com.hms.hms.User.UserDataTransferObject.WardenDto;
import com.hms.hms.User.UserService.AdminService;
import com.hms.hms.User.UserService.StudentService;
import com.hms.hms.User.UserService.WardenService;
import lombok.AllArgsConstructor;
import org.hibernate.boot.model.internal.WrappedInferredData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/wardens") 
public class WardenController {
    private WardenService wardenService;
    private StudentService studentService;
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
    //Get sub warden gender
    @GetMapping("/{WardenId}/students")
    public ResponseEntity<List<StudentDto>> getStudentsByWardenGender(@PathVariable("WardenId") String subWardenId) {
        Optional<Optional<WardenDto>> warden = Optional.ofNullable(Optional.ofNullable(wardenService.getWardenById(subWardenId)));
        if (warden.isPresent()) {
            List<StudentDto> students = studentService.getAllStudentByGender(warden.get().get().getGender());
            return ResponseEntity.ok(students);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/{wardenId}")
    public ResponseEntity<WardenDto>getWardenById(@PathVariable("wardenId") String warden_id){
        WardenDto wardenDto=wardenService.getWardenById(warden_id);
        return ResponseEntity.ok(wardenDto );
    }
    //Update a warden
    @PutMapping("/{wardenId}")
    public ResponseEntity<WardenDto>updateWarden(@PathVariable("wardenId") String wardenId, @RequestBody WardenDto wardenDto){
        WardenDto updatedWarden=wardenService.updatedWarden(wardenId, wardenDto);
        return ResponseEntity.ok(updatedWarden);
    }
    //Delete a warden
    @DeleteMapping("/{wardenId}")
    public ResponseEntity<String>deleteWarden(@PathVariable("wardenId") String warden_id){
        wardenService.deleteWarden(warden_id);
        return  ResponseEntity.ok("Warden deleted successfully");
    }
}
