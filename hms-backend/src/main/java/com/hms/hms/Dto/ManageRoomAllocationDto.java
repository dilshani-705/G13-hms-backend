package com.hms.hms.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ManageRoomAllocationDto {

    private int allocationID;

    private String hostel;

    private String level;
    private int roomNo;
}
