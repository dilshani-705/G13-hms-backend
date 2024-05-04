package com.hms.hms.User.UserEntity;

import jakarta.persistence.*;
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
@Table(name = "warden")
@PrimaryKeyJoinColumn(name = "warden_id", referencedColumnName = "user_id")
public class Warden extends User {

    public Warden(String userID, String fullName, String address, Date dob, String email, String gender, String nationality, String role, String contactNo, String password, String lecturePost) {
        super(userID, fullName, address, dob, email, gender, nationality, role, contactNo, password);
        this.lecturePost = lecturePost;

    }

    @Column(name = "lecture_post")
    private String lecturePost;

}
