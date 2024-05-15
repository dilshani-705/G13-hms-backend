package com.hms.hms.Service;


import com.hms.hms.Dto.AssetDto;
import com.hms.hms.Entity.Asset;
import com.hms.hms.Repo.AssetRepo;
import com.hms.hms.Util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AssetService {
    @Autowired
    private AssetRepo assetRepo;
    @Autowired
   private ModelMapper modelMapper;

    // Method to retrieve all assets from the asset table
    public List<AssetDto> viewAllAsset(){
        // Retrieve all assets from repository
        List<Asset> AssetList = assetRepo.findAll();
        // Convert to DTOs and return
        return modelMapper.map(AssetList,new TypeToken<List<AssetDto>>(){}.getType());
    }

    // Method to search and return an Asset by their ID from the Asset table
    public AssetDto searchAssetByID(int assetID){
        // Check if Asset exists
        if (assetRepo.existsById(assetID)){
            // Retrieve Asset from repository and map to DTO
            Asset asset = assetRepo.findById(assetID).orElse(null);
            return modelMapper.map(asset,AssetDto.class);
        }else{
            // Return null if Asset not found
            return null;
        }
    }

    // Method to save a new Asset in the Asset table
    public String addNewAsset(AssetDto assetDto){
        // Check if Asset ID already exists
        if(assetRepo.existsById(assetDto.getAssetID())){
            // Return response indicating duplication
            return VarList.RSP_DUPLICATED;
        }else{
            // Save new Asset to repository
            assetRepo.save(modelMapper.map(assetDto, Asset.class));
            // Return success response
            return VarList.RSP_SUCCESS;
        }
    }

    // Method to update an Asset in the Asset table
    public String updateAsset( AssetDto assetDto){
        // Check if Asset exists
        if(assetRepo.existsById(assetDto.getAssetID())){
            // Update Asset in repository
            assetRepo.save(modelMapper.map(assetDto,Asset.class));
            // Return success response
            return VarList.RSP_SUCCESS;
        }else{
            // Return response indicating Asset not found
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    // Method to delete an Asset from the Asset table
    public String deleteAssetByID(int assetID){
        // Check if Asset exists
        if (assetRepo.existsById(assetID)){
            // Delete Asset from repository
            assetRepo.deleteById(assetID);
            // Return success response
            return VarList.RSP_SUCCESS;
        }else{
            // Return response indicating Asset not found
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

}


