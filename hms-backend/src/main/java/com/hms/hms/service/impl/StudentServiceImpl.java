package com.hms.hms.service.impl;

import com.hms.hms.Dto.StudentDto;
import com.hms.hms.entity.Student;
import com.hms.hms.exception.ResourceNotFoundException;
import com.hms.hms.mapper.StudentMapper;
import com.hms.hms.repository.StudentRepository;
import com.hms.hms.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    @Override
    public StudentDto createStudent(StudentDto studentDto) {

        Student student= StudentMapper.mapToStudent(studentDto);
        Student saveStudent=studentRepository.save(student);
        return StudentMapper.mapToStudentDto(saveStudent);
    }

    @Override
    public StudentDto getStudentByID(Long studentId) {
        Student student=studentRepository.findById(studentId).orElseThrow(()->
                new ResourceNotFoundException("Student is not exists with given id:"+studentId));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student>students=studentRepository.findAll();
        return students.stream().map((student)->StudentMapper.mapToStudentDto(student)).collect(Collectors.toList());
    }

}
