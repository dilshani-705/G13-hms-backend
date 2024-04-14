package com.hms.hms.User.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "student_id")
public class Student extends User{
    public Student(String userID, String fullName, String address, Date dob, String email, String gender, String nationality, String role, String contactNo, String password, String department, String level, String guardianName, String guardianAddress, String guardianContactNo, String relationship) {
        super(userID, fullName, address, dob, email, gender, nationality, role, contactNo, password);
        this.department = department;
        this.level = level;
        this.guardianName = guardianName;
        this.guardianAddress = guardianAddress;
        this.guardianContactNo = guardianContactNo;
        this.relationship = relationship;
    }

    @Column(name="department")
    private String  department;
    @Column(name="level")
    private String level;
    @Column(name="guardian_name")
    private String guardianName;
    @Column(name ="guardian_address")
    private String guardianAddress;
    @Column(name = "guardian_contact_no")
    private String guardianContactNo;
    @Column(name = "relationship")
    private String relationship;

}
