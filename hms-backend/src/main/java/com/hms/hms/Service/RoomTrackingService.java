package com.hms.hms.Service;

import com.hms.hms.Entity.RoomMember;
import com.hms.hms.Repo.AssetTrackingRepo;
import com.hms.hms.Repo.RoomTrackingRepo;
import com.hms.hms.User.UserEntity.Student;
import com.hms.hms.User.UserRepository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTrackingService {
    @Autowired
    private RoomTrackingRepo roomTrackingRepo;

    @Autowired
    private AssetTrackingRepo assetTrackingRepo;

    public List<String> findMemberByRoomNo(String roomNo){
        return roomTrackingRepo.findMemberByRoomNo(roomNo);
    }


    public List<String> findAssetByRoomNo(String roomNo){
        return assetTrackingRepo.findAssetByRoomNo(roomNo);
    }

}
