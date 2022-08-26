package com.spring.companion.dto.subway;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SubwayLocationRequestDto {
    private Double lat;  // 위도

    private Double lng;  // 경도

    public SubwayLocationRequestDto(Double lng, Double lat){
        this.lng=lng;
        this.lat=lat;
    }

}
