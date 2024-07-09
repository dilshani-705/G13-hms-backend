package com.hms.hms.Repo;

import com.hms.hms.Entity.Asset;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssetRepo extends JpaRepository<Asset, Integer> {

    @Query("SELECT a FROM Asset a WHERE a.hostel = ?1 and a.allocatedRoom = ?2")
    List<Asset> findByRoomAndAllocatedRoom(String hostel, int allocatedRoom);

    @Modifying
    @Transactional
    @Query("UPDATE Asset a SET a.itemName = ?2 WHERE a.assetID = ?1")
    void updateAsset(int assetID, String updateItemName);

    @Query("SELECT a FROM Asset a WHERE a.assetID = ?1")
    Asset fetchUpdatedDetailByID(int assetID);
}
