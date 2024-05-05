package com.hms.hms.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AssetItemDto {

    private int assetItemID;
    private String assetItemName;
    private int count;

}
