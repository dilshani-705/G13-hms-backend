package com.hms.hms.Controller;

import com.hms.hms.Entity.RoomMember;
import com.hms.hms.Service.RoomTrackingService;
import com.hms.hms.User.UserEntity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/locationTracking")
@CrossOrigin
public class RoomTrackingController {

    @Autowired
    private RoomTrackingService roomTrackingService;
    @GetMapping(value = "/members/{roomNo}")
    public List<String> memberController(@PathVariable String roomNo){
        return roomTrackingService.findMemberByRoomNo(roomNo);
    }

    @GetMapping(value = "/assets/{roomNo}")
    public List<String> assetController(@PathVariable String roomNo){
        return roomTrackingService.findAssetByRoomNo(roomNo);
    }

}
