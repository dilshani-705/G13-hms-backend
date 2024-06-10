package com.hms.hms.User.AllUserMapper;

import com.hms.hms.User.UserDataTransferObject.StudentDto;
import com.hms.hms.User.UserEntity.Student;
import org.springframework.security.crypto.password.PasswordEncoder;

public class StudentMapper {
    private PasswordEncoder passwordEncoder;
    public StudentMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
public StudentDto mapStudentToDto(Student student) {
        return new StudentDto(
        student.getUserID(),
        student.getFullName(),
        student.getAddress(),
        student.getDob(),
        student.getEmail(),
        student.getGender(),
        student.getNationality(),
        student.getRole(),
        student.getContactNo(),
        this.passwordEncoder.encode(student.getPassword()),
        student.getDepartment(),
        student.getLevel(),
        student.getGuardianName(),
        student.getGuardianAddress(),
        student.getGuardianContactNo(),
        student.getRelationship(),
                student.getHostelID(),
                student.getRoomID()

        );
        }
    public Student mapDtoToStudent(StudentDto studentDto) {
        return new Student(
                studentDto.getUserID(),
                studentDto.getFullName(),
                studentDto.getAddress(),
                studentDto.getDob(),
                studentDto.getEmail(),
                studentDto.getGender(),
                studentDto.getNationality(),
                studentDto.getRole(),
                studentDto.getContactNo(),
                this.passwordEncoder.encode(studentDto.getPassword()),
                studentDto.getDepartment(),
                studentDto.getLevel(),
                studentDto.getGuardianName(),
                studentDto.getGuardianAddress(),
                studentDto.getGuardianContactNo(),
                studentDto.getRelationship(),
                studentDto.getHostelID(),
                studentDto.getRoomID()

        );
    }



}
