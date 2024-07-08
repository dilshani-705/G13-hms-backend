package com.hms.hms.Repo;

import com.hms.hms.Entity.RoomMember;
import com.hms.hms.User.UserEntity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomTrackingRepo extends JpaRepository <RoomMember, String> {

    @Query(value = "SELECT u.fullName FROM RoomMember rm JOIN  User u ON rm.MemberID = u.userID WHERE rm.room = ?1 and rm.hostel = ?2")
    public List<String> findMemberByRoomNo(String roomNo , String hostel);


//    @Query(value = "SELECT s.fullName FROM RoomMember rm WHERE rm.room = ?1 and rm.hostel = ?2")
//    public List<String> findMemberByRoomNo(String roomNo , String hostel);


}
