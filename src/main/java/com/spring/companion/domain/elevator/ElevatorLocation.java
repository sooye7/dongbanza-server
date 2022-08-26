package com.spring.companion.domain.elevator;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ElevatorLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer line;

    private String sub_name;

    private String elevator_code;

    private String section;

    private String elevator_loc;

    private String next_sub_name;

}
