package com.hms.hms.User.UserEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @Column(name="user_id")
    private String userID;
    @Column(name="full_name")
    private  String fullName;
    @Column(name="address")
    private String address;
    @Column(name="dob")
    private Date dob;
    @Column(name="email",nullable=false, unique=true)
    private String email;
    @Column(name="gender")
    private String gender;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "role")
    private String role;
    @Column(name = "contact_no")
    private String contactNo;
    @Column(name = "password")
    private String password;

    public void setPassword(String password, PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }
}
