package com.hms.hms.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "manage_room_allocation")
public class ManageRoomAllocation {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "allocation_id")
    private int allocationID;

    private String hostel;

    private String level;

    @Column (name = "room_no")
    private int roomNo;
}
