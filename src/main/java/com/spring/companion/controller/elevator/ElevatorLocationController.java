package com.spring.companion.controller.elevator;

import com.spring.companion.dto.elevator.ElevatorLocationRequestDto;
import com.spring.companion.dto.elevator.ExternalElevatorResponseDto;
import com.spring.companion.dto.elevator.InternalElevatorResponseDto;
import com.spring.companion.service.elevator.ElevatorLocationIntoService;
import com.spring.companion.service.elevator.ElevatorLocationOutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ElevatorLocationController {

    private final ElevatorLocationIntoService elevatorLocationIntoService;
    private final ElevatorLocationOutService elevatorLocationOutService;

    @GetMapping("/elevator/in")
    public List<ExternalElevatorResponseDto> intoSubwayStation(@RequestBody ElevatorLocationRequestDto elevatorLocationRequestDto){
        System.out.println(elevatorLocationRequestDto);
        // 지하철역 출구 엘리베이터 조회 (외부 엘리베이터)
        return elevatorLocationIntoService.getExternalElevator(elevatorLocationRequestDto);
    }

    // 승강장 번호 정보
    @GetMapping("/elevator/out")
    public List<InternalElevatorResponseDto> getOutOfSubwayStation(@RequestBody ElevatorLocationRequestDto elevatorLocationRequestDto){
        // 지하철역 내부에 있는 엘리베이터 조회
        return elevatorLocationOutService.getInternalElevator(elevatorLocationRequestDto);
    }


}
