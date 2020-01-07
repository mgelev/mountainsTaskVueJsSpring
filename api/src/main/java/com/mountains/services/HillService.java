package com.mountains.services;

import com.mountains.models.Hill;

import java.util.List;

public interface HillService {
    Hill getById(Integer id);
    List<Hill> getAllHills();
    List<Hill> getHillsByCountryId(Integer countryId);
    List<Hill> getHillsInRange(int from, int to);
    List<Hill> getHillsInRangeWithCountryId(int from, int to, Integer countryId);


}
