package com.hms.hms.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table (name = "asset_item")
public class AssetItem {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "asset_item_id")
    private int assetItemID;


    @Column(name = "asset_item_name")
    private String assetItemName;



}

