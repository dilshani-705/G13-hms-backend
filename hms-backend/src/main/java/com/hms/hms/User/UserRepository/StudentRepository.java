package com.hms.hms.User.UserRepository;

import com.hms.hms.User.UserDataTransferObject.StudentDto;
import com.hms.hms.User.UserEntity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,String > {

    List<Student> findAllByGender(String gender);

}
