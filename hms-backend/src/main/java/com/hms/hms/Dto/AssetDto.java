package com.hms.hms.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AssetDto {

    private int assetID;
    private String itemName;
    private String hostel;
    private int allocatedRoom;

}
