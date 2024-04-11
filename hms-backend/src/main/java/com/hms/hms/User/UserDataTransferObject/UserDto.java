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
public class UserDto {
    private String userID;
    private String fullName;
    private String address;
    private Date dob;
    private String email;
    private String gender;
    private String nationality;
    private String role;
    private String contactNo;
    private String password;


}