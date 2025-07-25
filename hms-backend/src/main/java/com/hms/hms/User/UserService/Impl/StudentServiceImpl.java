package com.hms.hms.User.UserService.Impl;

import com.hms.hms.User.AllUserMapper.StudentMapper;
import com.hms.hms.User.UserDataTransferObject.StudentDto;
import com.hms.hms.User.UserEntity.Student;
import com.hms.hms.User.UserRepository.StudentRepository;
import com.hms.hms.User.UserService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private PasswordEncoder passwordEncoder;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, PasswordEncoder passwordEncoder, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student= studentMapper.mapDtoToStudent(studentDto);
        Student savedStudent=studentRepository.save(student);
        return studentMapper.mapStudentToDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(String student_id) {
        Student student=studentRepository.findById(student_id)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+student_id));
        return studentMapper.mapStudentToDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> student=studentRepository.findAll();
        return student.stream().map((studentMapper::mapStudentToDto)).collect(Collectors.toList());
    }

    @Override
    public StudentDto updatedStudent(String student_id, StudentDto updatedStudent) {
        Student student=studentRepository.findById(student_id)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+student_id));
        student.setFullName(updatedStudent.getFullName());
        student.setAddress(updatedStudent.getAddress());
        student.setDob(updatedStudent.getDob());
        student.setEmail(updatedStudent.getEmail());
        student.setGender(updatedStudent.getGender());
        student.setNationality(updatedStudent.getNationality());
        student.setRole(updatedStudent.getRole());
        student.setContactNo(updatedStudent.getContactNo());
        student.setDepartment(updatedStudent.getDepartment());
        student.setLevel(updatedStudent.getLevel());
        student.setGuardianName(updatedStudent.getGuardianName());
        student.setGuardianContactNo(updatedStudent.getGuardianContactNo());
        student.setGuardianAddress(updatedStudent.getGuardianAddress());
        student.setRelationship(updatedStudent.getRelationship());
        student.setHostelID(updatedStudent.getHostelID());
        student.setRoomID(updatedStudent.getRoomID());
        if(updatedStudent.getPassword()!=null){
            student.setPassword(updatedStudent.getPassword(),passwordEncoder);
        }

        studentRepository.save(student);
        return studentMapper.mapStudentToDto(student);
    }

    @Override
    public Student updateStudentPartial(String studentId, Map<String, Object> updates) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + studentId));

        updates.forEach((key, value) -> {
            switch (key) {
                case "hostel":
                    student.setHostelID((String) value);
                    break;
                case "room":
                    student.setRoomID((String) value);
                    break;
                // Add more fields as needed
            }
        });

        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(String student_id) {
        Student student=studentRepository.findById(student_id)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+student_id));

        studentRepository.deleteById(student_id);
    }

    @Override
    public List<StudentDto> getAllStudentByGender(String gender) {
        List<Student> students = studentRepository.findAllByGender(gender);
        return students.stream().map(studentMapper::mapStudentToDto).collect(Collectors.toList());
    }
}
