package com.hms.hms.User.UserController;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserDataTransferObject.MaintenanceSupervisorDto;
import com.hms.hms.User.UserDataTransferObject.StudentDto;
import com.hms.hms.User.UserEntity.Student;
import com.hms.hms.User.UserRepository.StudentRepository;
import com.hms.hms.User.UserService.AdminService;
import com.hms.hms.User.UserService.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    //See all students
    @GetMapping
    public ResponseEntity<List<StudentDto>>getAllStudents(){
        List<StudentDto>student=studentService.getAllStudents();
        return ResponseEntity.ok(student);
    }
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDto>getStudentById(@PathVariable("studentId") String student_id){
        StudentDto studentDto=studentService.getStudentById(student_id);
        return ResponseEntity.ok(studentDto);
    }
    //Update a student
    @PutMapping("/{studentId}")
    public ResponseEntity<StudentDto>updateStudent(@PathVariable("studentId") String studentId, @RequestBody StudentDto updatedStudent){
        StudentDto studentDto=studentService.updatedStudent(studentId,updatedStudent);
        return ResponseEntity.ok(studentDto);
    }
    //Student Registration
    @PutMapping("/{id}/registration")
    public ResponseEntity<Student> updateStudentPartial(@PathVariable("id") String id, @RequestBody Map<String, Object> updates) {
        Student updatedStudent = studentService.updateStudentPartial(id, updates);
        return ResponseEntity.ok(updatedStudent);
    }
    //Delete a student
    @DeleteMapping("/{studentId}")
    public ResponseEntity<String>deleteStudent(@PathVariable("studentId") String student_id){
        studentService.deleteStudent(student_id);
        return  ResponseEntity.ok("Student deleted successfully");
    }
}
