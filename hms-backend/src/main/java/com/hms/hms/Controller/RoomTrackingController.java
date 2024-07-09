package com.hms.hms.Controller;

import com.hms.hms.Entity.RoomMember;
import com.hms.hms.Service.RoomTrackingService;
import com.hms.hms.User.UserEntity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/roomTracking")
@CrossOrigin
public class RoomTrackingController {

    @Autowired
    private RoomTrackingService roomTrackingService;
    @GetMapping(value = "/members/{roomNo}/{hostel}")
    public List<String> memberController(@PathVariable String roomNo , @PathVariable String hostel){
        return roomTrackingService.findMemberByRoomNo(roomNo , hostel);
    }

    @GetMapping(value = "/assets/{roomNo}/{hostel}")
    public List<String> assetController(@PathVariable String roomNo , @PathVariable String hostel){
        return roomTrackingService.findAssetByRoomNo(roomNo ,  hostel);
    }

}
