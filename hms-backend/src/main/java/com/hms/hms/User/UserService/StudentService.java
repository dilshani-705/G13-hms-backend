package com.hms.hms.User.UserService;

import com.hms.hms.User.UserDataTransferObject.StudentDto;
import com.hms.hms.User.UserEntity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(String student_id);
    List<StudentDto> getAllStudents();
    StudentDto updatedStudent(String userId, StudentDto updatedStudent);
    Student updateStudentPartial(String studentId, Map<String, Object> updates);

    void deleteStudent(String userId);
    List<StudentDto> getAllStudentByGender(String gender);
}
