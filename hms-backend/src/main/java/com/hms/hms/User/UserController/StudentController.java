package com.hms.hms.User.UserController;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserDataTransferObject.StudentDto;
import com.hms.hms.User.UserService.AdminService;
import com.hms.hms.User.UserService.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;
    //Add a student
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto savedStudent=studentService.createStudent(studentDto);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);

    }
}
