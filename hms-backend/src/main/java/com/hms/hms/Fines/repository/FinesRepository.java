package com.hms.hms.Fines.repository;
import com.hms.hms.Fines.entity.Fines;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinesRepository extends JpaRepository<Fines,Long> {
}
