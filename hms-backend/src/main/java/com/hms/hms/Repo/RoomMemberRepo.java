package com.hms.hms.Repo;

import com.hms.hms.Entity.AssetItem;
import com.hms.hms.Entity.RoomMember;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomMemberRepo extends JpaRepository<RoomMember, String> {

}

