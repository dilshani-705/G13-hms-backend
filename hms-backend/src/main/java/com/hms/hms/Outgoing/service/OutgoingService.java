package com.hms.hms.Outgoing.service;

import com.hms.hms.Outgoing.Dto.OutgoingDto;

import java.util.List;

public interface OutgoingService {
    OutgoingDto createOutgoing(OutgoingDto outgoingDto);
    List<OutgoingDto> getAllOutgoing();
}
