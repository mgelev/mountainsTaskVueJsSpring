package com.mountains.services.impl;

import com.mountains.models.Country;
import com.mountains.repository.CountryRepository;
import com.mountains.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryById(Integer id) {
        return countryRepository.getById(id);
    }
}
