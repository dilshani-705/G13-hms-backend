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
public class WardenDto extends UserDto {
    public WardenDto(String userID, String fullName, String address, Date dob, String email, String gender, String nationality, String role, String contactNo, String password, String lecturePost) {
        super(userID, fullName, address, dob, email, gender, nationality, role, contactNo, password);
        this.lecturePost = lecturePost;
    }

    private String lecturePost;
}
