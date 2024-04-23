package com.hms.hms.Outgoing.mapper;

import com.hms.hms.Outgoing.Dto.OutgoingDto;
import com.hms.hms.Outgoing.entity.Outgoing;


public class OutgoingMapper {

    public static OutgoingDto mapToOutgoingDto(Outgoing outgoing){
        return new OutgoingDto(
              outgoing.getOutgoingId(),
              outgoing.getSelectOutgoingType(),
              outgoing.getSelectHostelType(),
              outgoing.getDepartureDate(),
              outgoing.getTgNumber(),
              outgoing.getRoomNumber(),
              outgoing.getFullName(),
              outgoing.getDepartureTime(),
              outgoing.getLeavingPlace(),
                outgoing.getArrivalDate(),
                outgoing.getArrivalTime()
        );


    }

    public static Outgoing mapToOutgoing(OutgoingDto outgoingDto){
        return new Outgoing(
                outgoingDto.getOutgoingId(),
                outgoingDto.getSelectOutgoingType(),
                outgoingDto.getSelectHostelType(),
                outgoingDto.getDepartureDate(),
                outgoingDto.getTgNumber(),
                outgoingDto.getRoomNumber(),
                outgoingDto.getFullName(),
                outgoingDto.getDepartureTime(),
                outgoingDto.getLeavingPlace(),
                outgoingDto.getArrivalDate(),
                outgoingDto.getArrivalTime()
        );
    }

}
