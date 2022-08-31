package com.spring.companion.service.elevator;

import com.spring.companion.domain.elevator.ElevatorLocation;
import com.spring.companion.domain.elevator.repository.ElevatorLocationRepository;
import com.spring.companion.dto.elevator.ElevatorLocationRequestDto;
import com.spring.companion.dto.elevator.InternalElevatorResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * 지하철에서 나가는 경우 다음역에 따라 무슨 방면인지, 방향(상행, 하행, 외선, 내선)
 * ex) 논현 방면, 상행 4-2
 */

@Service
@RequiredArgsConstructor
public class ElevatorLocationOutService {
    private final ElevatorLocationRepository elevatorLocationRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public List<InternalElevatorResponseDto> getInternalElevator(ElevatorLocationRequestDto elevatorLocationRequestDto) {
        // 예외처리 필요 (NULL일 경우 "업데이트 중입니다.")
        List<InternalElevatorResponseDto> internalElevatorResponseDtoList
                =entityListToResponseList(elevatorLocationRepository.findInternalEVBySubName(elevatorLocationRequestDto.getLine(),elevatorLocationRequestDto.getSub_name()));
        if(internalElevatorResponseDtoList.isEmpty())
            internalElevatorResponseDtoList.add(new InternalElevatorResponseDto("업데이트 중입니다"));
        return internalElevatorResponseDtoList;
    }


    @Transactional
    public List<InternalElevatorResponseDto> entityListToResponseList(List<ElevatorLocation> elevatorLocationList){
        return elevatorLocationList
                .stream()
                .map(elevatorLocation -> modelMapper.map(elevatorLocation, InternalElevatorResponseDto.class))
                .collect(Collectors.toList());
    }
}
