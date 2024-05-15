package com.hms.hms.Repo;


import com.hms.hms.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location,Integer> {
}
