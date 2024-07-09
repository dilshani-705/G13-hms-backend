package com.hms.hms.Repo;


import com.hms.hms.Entity.ManageRoomAllocation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ManageRoomAllocationRepo extends JpaRepository<ManageRoomAllocation, Integer> {

//    @Query(value = "SELECT CASE WHEN COUNT(m) > 0 THEN TRUE ELSE FALSE END FROM ManageRoomAllocation m WHERE m.hostel = ?1 AND m.level = ?2 AND m.roomNo = ?3")
//    boolean duplicateSearch01(String hostel, String level, int roomNo);

    @Query(value = "SELECT CASE WHEN COUNT(m) > 0 THEN TRUE ELSE FALSE END FROM ManageRoomAllocation m WHERE m.hostel = ?1 AND m.roomNo = ?2")
    boolean duplicateSearch01(String hostel, int roomNo);

    @Query(value = "SELECT CASE WHEN COUNT(m) > 0 THEN TRUE ELSE FALSE END FROM ManageRoomAllocation m WHERE m.hostel = ?1 AND m.level = ?2 AND m.roomNo = ?3")
    boolean duplicateSearch001(String hostel, String level, int updateRoomNo);

    @Query(value = "SELECT CASE WHEN COUNT(m) > 0 THEN TRUE ELSE FALSE END FROM ManageRoomAllocation m WHERE m.hostel = ?1 AND m.roomNo = ?2")
    boolean duplicateSearch02(String hostel, int updateRoomNo);

//    @Query(value = "SELECT CASE WHEN COUNT(m) > 0 THEN TRUE ELSE FALSE END FROM ManageRoomAllocation m WHERE m.hostel = ?1 AND m.level = ?2")
//    boolean existsByHostelAndLevel(String hostel, String level);

    @Query(value = "SELECT m FROM ManageRoomAllocation m  WHERE m.hostel = ?1 and m.level = ?2")
    List<ManageRoomAllocation> findByRoomAndHostel(String hostel , String level);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ManageRoomAllocation m SET m.roomNo = ?2 WHERE m.allocationID = ?1")
    void updateRoom(int allocationID, int updateRoomNo);

    @Query(value = "SELECT m FROM ManageRoomAllocation m  WHERE m.allocationID = ?1")
    ManageRoomAllocation fetchUpdatedDetailByID(int allocationID);




}
