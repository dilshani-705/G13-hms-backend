package com.hms.hms.User.AllUserMapper;

import com.hms.hms.User.UserDataTransferObject.StudentDto;
import com.hms.hms.User.UserEntity.Student;

public class StudentMapper {
public static StudentDto mapStudentToDto(Student student) {
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
        student.getPassword(),
        student.getDepartment(),
        student.getLevel(),
        student.getGuardianName(),
        student.getGuardianAddress(),
        student.getGuardianContactNo(),
        student.getRelationship()
        );
        }
    public static Student mapDtoToStudent(StudentDto studentDto) {
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
                studentDto.getPassword(),
                studentDto.getDepartment(),
                studentDto.getLevel(),
                studentDto.getGuardianName(),
                studentDto.getGuardianAddress(),
                studentDto.getGuardianContactNo(),
                studentDto.getRelationship()
        );
    }



}
