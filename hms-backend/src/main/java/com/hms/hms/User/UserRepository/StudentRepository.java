package com.hms.hms.User.UserRepository;

import com.hms.hms.User.UserEntity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,String > {
}
