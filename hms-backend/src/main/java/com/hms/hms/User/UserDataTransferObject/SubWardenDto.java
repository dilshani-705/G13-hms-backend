package com.hms.hms.User.UserDataTransferObject;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubWardenDto extends UserDto {

    public SubWardenDto(String userID, String fullName, String address, Date dob, String email, String gender, String nationality, String role, String contactNo, String password, Date dateOfEmployment) {
        super(userID, fullName, address, dob, email, gender, nationality, role, contactNo, password);
        this.dateOfEmployment = dateOfEmployment;

    }

    private Date dateOfEmployment;
}
