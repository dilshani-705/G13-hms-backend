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
public class Warden extends User {
    public Warden(String userID, String fullName, String address, Date dob, String email, String gender, String nationality, String role, String contactNo, String password, String lecturePost) {
        super(userID, fullName, address, dob, email, gender, nationality, role, contactNo, password);
        this.lecturePost = lecturePost;
    }

    @Column(name = "lecture_post")
    private String lecturePost;

}
