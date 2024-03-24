package com.hms.hms.controller;

import com.hms.hms.Dto.StudentDto;
import com.hms.hms.entity.Student;
import com.hms.hms.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;

    //Build Add Student REST API
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto saveStudent= studentService.createStudent(studentDto);
        return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
    }

    //Build Get Stu
    @GetMapping("{id}")
    public ResponseEntity<StudentDto>getStudentById(@PathVariable("id")Long studentId){
        StudentDto studentDto=studentService.getStudentByID(studentId);
        return ResponseEntity.ok(studentDto);
    }

    //Get All
    @GetMapping
    public ResponseEntity<List<StudentDto>>getAllStudent(){
        List<StudentDto>student=studentService.getAllStudent();
        return ResponseEntity.ok(student);
    }

}
