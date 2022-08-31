package com.spring.companion.service.elevator;

import com.spring.companion.domain.elevator.ElevatorLocation;
import com.spring.companion.domain.elevator.repository.ElevatorLocationRepository;
import com.spring.companion.dto.elevator.ElevatorLocationRequestDto;
import com.spring.companion.dto.elevator.ExternalElevatorResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * 지하철으로 들어가는 경우 출구
 */

@Service
@RequiredArgsConstructor
public class ElevatorLocationIntoService {

    private final ElevatorLocationRepository elevatorLocationRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public List<ExternalElevatorResponseDto> getExternalElevator(ElevatorLocationRequestDto elevatorLocationRequestDto) {
        // 예외처리 필요 (NULL일 경우 "업데이트 중입니다.")
        List<ExternalElevatorResponseDto> externalElevatorResponseDtoList
                =entityListToResponseList(elevatorLocationRepository.findExternalEVBySubName(elevatorLocationRequestDto.getLine(),elevatorLocationRequestDto.getSub_name()));
        if(externalElevatorResponseDtoList.isEmpty())
            externalElevatorResponseDtoList.add(new ExternalElevatorResponseDto("업데이트 중입니다"));
        return externalElevatorResponseDtoList;
    }


    @Transactional
    public List<ExternalElevatorResponseDto> entityListToResponseList(List<ElevatorLocation> elevatorLocationList){
        return elevatorLocationList
                .stream()
                .map(elevatorLocation -> modelMapper.map(elevatorLocation, ExternalElevatorResponseDto.class))
                .collect(Collectors.toList());
    }

}
