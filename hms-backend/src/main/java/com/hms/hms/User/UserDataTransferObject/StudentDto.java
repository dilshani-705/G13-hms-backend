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
public class StudentDto extends UserDto {

    public StudentDto(String userID, String fullName, String address, Date dob, String email, String gender, String nationality, String role, String contactNo, String password, String department, String level, String guardianName, String guardianAddress, String guardianContactNo, String relationship,String hostelID,String  roomID){
        super(userID, fullName, address, dob, email, gender, nationality, role, contactNo, password);
        this.department = department;
        this.level = level;
        this.guardianName = guardianName;
        this.guardianAddress = guardianAddress;
        this.guardianContactNo = guardianContactNo;
        this.relationship = relationship;
        this.hostelID=hostelID;
        this.roomID=roomID;}

    private String department;
    private String level;
    private String guardianName;
    private String guardianAddress;
    private String guardianContactNo;
    private String relationship;
    private String hostelID;
    private  String roomID;
}
