package com.hms.hms.User.UserEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "admin_id", referencedColumnName = "user_id")
public class Admin extends User {


    public Admin(String userID, String fullName, String address, Date dob, String email, String gender, String nationality, String role, String contactNo, String password) {
        super(userID, fullName, address, dob, email, gender, nationality, role, contactNo, password);

    }
}