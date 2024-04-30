package com.hms.hms.Fines.mapper;

import com.hms.hms.Fines.Dto.FinesDto;
import com.hms.hms.Fines.entity.Fines;

public class FinesMapper {
    public static FinesDto mapToFinesDto(Fines fines){
        return new FinesDto(
                fines.getFinesId(),
                fines.getFullName(),
                fines.getTgNumber(),
                fines.getSubmitDate(),
                fines.getProofImage(),
                fines.getStatus()
        );
    }

    public static Fines mapToFines(FinesDto finesDto){
        return new Fines(
                finesDto.getFinesId(),
                finesDto.getFullName(),
                finesDto.getTgNumber(),
                finesDto.getSubmitDate(),
                finesDto.getProofImage(),
                finesDto.getStatus()
        );
    }

}
