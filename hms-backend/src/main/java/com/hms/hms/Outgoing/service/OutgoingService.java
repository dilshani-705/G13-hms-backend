package com.hms.hms.Outgoing.service;

import com.hms.hms.Outgoing.Dto.OutgoingDto;
import com.hms.hms.Outgoing.entity.Outgoing;

import java.util.List;

public interface OutgoingService {
    OutgoingDto createOutgoing(OutgoingDto outgoingDto);
    List<OutgoingDto> getAllOutgoing();

    OutgoingDto updateOutgoing(Long outgoingId,OutgoingDto updateOutgoing);
    void deleteOutgoing (Long outgoingId);

    List<OutgoingDto> getOutgoingByType(String selectOutgoingType);
    List<OutgoingDto> getOutgoingByHostelType(String selectHostelType);

    List<OutgoingDto> findOutgoingsWithNullArrivalDate();



}
