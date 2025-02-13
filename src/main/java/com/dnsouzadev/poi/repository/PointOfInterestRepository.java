package com.dnsouzadev.poi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dnsouzadev.poi.entity.PointOfInterest;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Long> {

    @Query("""
            SELECT p FROM PointOfInterest p
            WHERE (p.x >= :xMin AND p.x <= :xMax AND p.y >= :yMin AND p.y <= :yMax)
            """)
    List<PointOfInterest> findNear(@Param("xMin") Long xMin, @Param("xMax") Long xMax, @Param("yMin") Long yMin, @Param("yMax") Long yMax);
}
