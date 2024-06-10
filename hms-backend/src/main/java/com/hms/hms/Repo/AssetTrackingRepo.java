package com.hms.hms.Repo;

import com.hms.hms.Entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssetTrackingRepo extends JpaRepository<Asset, Integer> {

    @Query(value = "SELECT a.itemName FROM Asset a  WHERE a.allocatedLocation = ?1 ORDER BY a.itemName ASC")
    public List<String> findAssetByRoomNo(String roomNo);
}
