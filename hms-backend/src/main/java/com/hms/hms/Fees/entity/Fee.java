package com.hms.hms.Fees.entity;

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
    private long FeeId;

    @Column (name="full_name")
    private String fullName;

    @Column (name="tg_number")
    private String tgNumber;

    @Column (name="submit_date")
    private String submitDate;

    @Lob
    @Column(name = "proof_image", columnDefinition = "LONGBLOB")
    private byte[] proofImage;

    @Column (name="status")
    private String status;

}
