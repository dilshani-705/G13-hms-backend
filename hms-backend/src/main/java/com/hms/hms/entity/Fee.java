package com.hms.hms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fee")
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AcademicYear") //Colum name
    private String academicYear; //Feild name

    @Column(name = "Amount")
    private String amount;

    @Column(name = "Deadline")
    private String deadline;

}
