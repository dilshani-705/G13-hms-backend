package com.hms.hms.User.UserService;

import com.hms.hms.User.UserDataTransferObject.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(String userId);
    List<StudentDto> getAllStudents();
    StudentDto updatedStudent(String userId, StudentDto updatedStudent);
    void deleteStudent(String userId);

}
