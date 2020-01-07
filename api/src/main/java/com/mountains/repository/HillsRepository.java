package com.mountains.repository;

import com.mountains.models.Hill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HillsRepository extends JpaRepository<Hill,Integer> {
    @Query(
            value = "SELECT * FROM hills h WHERE h.country_id = ?1",
            nativeQuery = true)
    List<Hill> findAllByCountryId(Integer countryId);
}
