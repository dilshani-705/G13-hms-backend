package com.hms.hms.Repo;


import com.hms.hms.Entity.RoomMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RoomMemberRepo extends JpaRepository<RoomMember, String> {

    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM Student s WHERE s.userID =?1 AND s.hostelID = ?2 AND s.level = ?3")
    boolean existsByMemberIdAndHostelIdAndLevel(String memberId, String hostelId, String level);


    // Query to find room numbers by hostel and level
    @Query("SELECT m.roomNo FROM ManageRoomAllocation m WHERE m.hostel = ?1 AND m.level = ?2")
    List<String> findRoomNumbersByHostelAndLevel(String hostel, String level);

    @Query("SELECT CASE WHEN COUNT(rm) > 0 THEN TRUE ELSE FALSE END FROM RoomMember rm WHERE rm.hostel = ?1 AND rm.room = ?2")
    boolean findDuplicateRoomNo(String hostel, String newRoomNumber);

}
