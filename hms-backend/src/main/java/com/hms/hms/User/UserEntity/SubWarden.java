package com.hms.hms.User.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class SubWarden extends User {
    public SubWarden(String userID, String fullName, String address, Date dob, String email, String gender, String nationality, String role, String contactNo, String password, Date dateOfEmployment) {
        super(userID, fullName, address, dob, email, gender, nationality, role, contactNo, password);
        this.dateOfEmployment = dateOfEmployment;
    }

    @Column(name = "date_of_employment")
    private Date dateOfEmployment;
}