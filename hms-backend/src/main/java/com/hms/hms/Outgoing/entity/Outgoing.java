package com.hms.hms.Outgoing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "outgoing")
public class Outgoing {

    //selectOutgoingType,selectHostelType,departureDate,tgNumber,roomNumber,fullName,departureTime,leavingPlace

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long OutgoingId;
    @Column (name="OutgoingType")
    private String selectOutgoingType;
    @Column (name="HostelType")
    private String selectHostelType;
    @Column (name="DepartureDate")
    private String departureDate;
    @Column (name="TgNumber")
    private String tgNumber;
    @Column (name="RoomNumber")
    private String roomNumber;
    @Column (name="FullName")
    private String fullName;
    @Column (name="DepartureTime")
    private String departureTime;
    @Column (name="LeavingPlace")
    private String leavingPlace;
    @Column (name="ArrivalDate")
    private String arrivalDate;
    @Column (name="ArrivalTime")
    private String arrivalTime;

}
