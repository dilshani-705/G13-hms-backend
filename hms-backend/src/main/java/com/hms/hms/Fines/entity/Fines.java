package com.hms.hms.Fines.entity;

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
@Table(name = "fines")
public class Fines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long finesId;

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
