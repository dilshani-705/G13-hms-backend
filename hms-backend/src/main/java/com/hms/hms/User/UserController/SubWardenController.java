package com.hms.hms.User.UserController;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserDataTransferObject.MaintenanceSupervisorDto;
import com.hms.hms.User.UserDataTransferObject.StudentDto;
import com.hms.hms.User.UserDataTransferObject.SubWardenDto;
import com.hms.hms.User.UserService.AdminService;
import com.hms.hms.User.UserService.StudentService;
import com.hms.hms.User.UserService.SubWardenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/sub_wardens")
public class SubWardenController {
    private SubWardenService subWardenService;
    private StudentService studentService;
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
    //Get sub warden gender
    @GetMapping("/{subWardenId}/students")
    public ResponseEntity<List<StudentDto>> getStudentsBySubWardenGender(@PathVariable("subWardenId") String subWardenId) {
        Optional<Optional<SubWardenDto>> subWarden = Optional.ofNullable(Optional.ofNullable(subWardenService.getSubWardenById(subWardenId)));
        if (subWarden.isPresent()) {
            List<StudentDto> students = studentService.getAllStudentByGender(subWarden.get().get().getGender());
            return ResponseEntity.ok(students);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
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
    //delete a sub warden
    @DeleteMapping("/{subWardenId}")
    public ResponseEntity<String>deleteSubWarden(@PathVariable("subWardenId") String subWarden_id){
        subWardenService.deleteSubWarden(subWarden_id);
        return ResponseEntity.ok("SubWarden deleted successfully");
    }
}
