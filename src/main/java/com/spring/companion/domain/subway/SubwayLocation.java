package com.spring.companion.domain.subway;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="sub_location")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SubwayLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="line")
    private Integer line;

    @Column(name="sub_name")
    private String sub_name;

    @Column(name="sub_code")
    private String sub_code;

    @Column(name="lat")
    private Double lat;  // 위도

    @Column(name="lng")
    private Double lng;  // 경도
}
