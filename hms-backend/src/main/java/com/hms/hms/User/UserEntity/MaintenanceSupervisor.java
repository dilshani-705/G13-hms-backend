package com.hms.hms.User.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

 @Getter
@Setter
@NoArgsConstructor
@Entity
 @PrimaryKeyJoinColumn(name = "maintenance_supvisor_id")
public class MaintenanceSupervisor extends User {
    public MaintenanceSupervisor(String userID, String fullName, String address, Date dob, String email, String gender, String nationality, String role, String contactNo, String password) {
        super(userID, fullName, address, dob, email, gender, nationality, role, contactNo, password);
    }
}
