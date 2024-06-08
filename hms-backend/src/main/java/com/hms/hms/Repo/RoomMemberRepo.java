package com.hms.hms.Repo;

import com.hms.hms.Entity.AssetItem;
import com.hms.hms.Entity.RoomMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomMemberRepo extends JpaRepository<RoomMember,String> {
}
