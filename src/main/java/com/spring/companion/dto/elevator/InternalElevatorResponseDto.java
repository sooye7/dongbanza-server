package com.spring.companion.dto.elevator;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InternalElevatorResponseDto {
    String elevator_loc;

    String next_sub_name;

    public InternalElevatorResponseDto(String elevator_loc){
        this.elevator_loc=elevator_loc;
    }
}
