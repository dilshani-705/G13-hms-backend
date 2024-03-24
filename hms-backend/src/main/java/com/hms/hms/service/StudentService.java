package com.hms.hms.service;

import com.hms.hms.Dto.StudentDto;

import java.util.List;

public interface StudentService {
   StudentDto createStudent(StudentDto studentDto);

StudentDto getStudentByID(Long studentId);

   List<StudentDto>getAllStudent();
}
