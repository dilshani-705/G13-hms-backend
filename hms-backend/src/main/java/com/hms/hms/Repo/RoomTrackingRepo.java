package com.hms.hms.Repo;

import com.hms.hms.Entity.RoomMember;
import com.hms.hms.User.UserEntity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomTrackingRepo extends JpaRepository <RoomMember, String> {

    @Query(value = "SELECT s.fullName FROM RoomMember rm JOIN Student s ON rm.MemberID = s.userID WHERE rm.RoomID = ?1")
    public List<String> findMemberByRoomNo(String roomNo);





}
