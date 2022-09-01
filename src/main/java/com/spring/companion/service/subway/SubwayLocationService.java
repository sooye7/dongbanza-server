package com.spring.companion.service.subway;

import com.spring.companion.domain.subway.SubwayLocation;
import com.spring.companion.domain.subway.repository.SubwayLocationRepository;
import com.spring.companion.dto.subway.SubwayLocationRequestDto;
import com.spring.companion.dto.subway.SubwayLocationResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubwayLocationService {
    private final SubwayLocationRepository subwayLocationRepository;
    private final ModelMapper modelMapper;

//    @Transactional
//    public List<SubwayLocationResponseDto> getSubwayStationList(SubwayLocationRequestDto subwayLocationRequestDto){
//        // repository에서 근처 역 LIST 받아오기
//        System.out.println(subwayLocationRequestDto.getLng());
//        System.out.println(subwayLocationRequestDto.getLat());
//        return entityListToResponseList(subwayLocationRepository.
//                findCurrentSubwayStationByPosition(subwayLocationRequestDto.getLng(),subwayLocationRequestDto.getLat()));
//    }

    @Transactional
    public SubwayLocationResponseDto getSubwayStationList(SubwayLocationRequestDto subwayLocationRequestDto){
        // repository에서 근처 역 LIST 받아오기
        System.out.println(subwayLocationRequestDto.getLng());
        System.out.println(subwayLocationRequestDto.getLat());
        return entityListToResponseList(subwayLocationRepository.
                findCurrentSubwayStationByPosition(subwayLocationRequestDto.getLng(),subwayLocationRequestDto.getLat())).get(0);
    }

    @Transactional
    public List<SubwayLocationResponseDto> entityListToResponseList(List<SubwayLocation> subwayLocationList){
        return subwayLocationList
                .stream()
                .map(subwayLocation -> modelMapper.map(subwayLocation, SubwayLocationResponseDto.class))
                .collect(Collectors.toList());
    }

}
