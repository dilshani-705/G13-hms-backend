package com.hms.hms.User.UserDataTransferObject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AdminDto extends UserDto {


    public AdminDto(String userID, String fullName, String address, Date dob, String email, String gender, String nationality, String role, String contactNo, String password) {
        super(userID, fullName, address, dob, email, gender, nationality, role, contactNo, password);

    }


}
