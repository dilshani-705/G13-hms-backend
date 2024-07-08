package com.hms.hms.Dto;

import lombok.Data;

import java.util.List;

@Data
public class RoomMemberCheckRequest {

    private List<String> roomMembers;
    private String hostel;
    private String level;

}