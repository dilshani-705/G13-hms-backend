package com.hms.hms.Outgoing.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OutgoingDto {

    private long OutgoingId;

    private String selectOutgoingType;

    private String selectHostelType;

    private String departureDate;

    private String tgNumber;

    private String roomNumber;

    private String fullName;

    private String departureTime;

    private String leavingPlace;

    private String ArrivalDate;

    private String ArrivalTime;
}
