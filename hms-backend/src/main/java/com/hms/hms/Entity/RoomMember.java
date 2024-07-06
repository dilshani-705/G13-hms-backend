package com.hms.hms.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "room_member")
public class RoomMember {
    @Id
    @Column(name = "member_id")
    private String MemberID;

    private int room;

    private String hostel;
}
