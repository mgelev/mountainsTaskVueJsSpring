package com.mountains.services;

import com.mountains.models.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAll();
    Country getCountryById(Integer id);
}
