package com.spring.companion.dto.elevator;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExternalElevatorResponseDto {
    String elevator_loc;

    public ExternalElevatorResponseDto(String elevator_loc){
        this.elevator_loc=elevator_loc;
    }
}
