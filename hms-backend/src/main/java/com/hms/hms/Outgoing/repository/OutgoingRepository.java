package com.hms.hms.Outgoing.repository;

import com.hms.hms.Fees.entity.Fee;
import com.hms.hms.Outgoing.entity.Outgoing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutgoingRepository extends JpaRepository<Outgoing,Long> {
    List<Outgoing> findBySelectOutgoingType(String selectOutgoingType);
    List<Outgoing> findBySelectHostelType(String selectHostelType);
//    List<Outgoing> findByArrivalDateIsNull();
    List<Outgoing> findByArrivalDateIsNull();
}
