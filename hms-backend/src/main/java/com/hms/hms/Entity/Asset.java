package com.hms.hms.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "asset")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asset_id")
    private int assetID;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "receipt_date")
    private String receiptDate;

    @Column(name = "allocated_room")
    private int allocatedRoom;
}
