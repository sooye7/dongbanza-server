package com.spring.companion.domain.subway.repository;

import com.spring.companion.domain.subway.SubwayLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubwayLocationRepository extends JpaRepository<SubwayLocation,Long>, SubwayLocationCustomRepository {
    @Query(value= "SELECT * " +
            "FROM sub_location " +
            "WHERE ST_Distance_Sphere(POINT(:lng, :lat), POINT(lng, lat)) <= 2000 " +
            "ORDER BY ST_Distance_Sphere(POINT(:lng, :lat), POINT(lng, lat))", nativeQuery = true)
    public List<SubwayLocation> findCurrentSubwayStationByPosition( @Param("lng") Double lng, @Param("lat") Double lat);
}
