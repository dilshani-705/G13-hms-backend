package com.hms.hms.Repo;


import com.hms.hms.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room,Integer> {

    boolean existsByRoom(int room);

    boolean existsByRoomAndHostel(int room , String hostel);

}
