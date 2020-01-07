package com.mountains.services.impl;

import com.mountains.models.Hill;
import com.mountains.repository.CountryRepository;
import com.mountains.repository.HillsRepository;
import com.mountains.services.HillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HillServiceImpl implements HillService {
    private final HillsRepository hillsRepository;
    private final CountryRepository countryRepository;


    @Autowired
    public HillServiceImpl(HillsRepository hillsRepository, CountryRepository countryRepository) {
        this.hillsRepository = hillsRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Hill getById(Integer id) {
        return hillsRepository.getOne(id);
    }

    @Override
    public List<Hill> getAllHills() {
        return hillsRepository.findAll();
    }

    @Override
    public List<Hill> getHillsByCountryId(Integer countryId) {
        return hillsRepository.findAllByCountryId(countryId);
    }

    @Override
    public List<Hill> getHillsInRange(int from, int to) {
       int fromChanged = Math.abs(from);
       int toChanged = Math.abs(to);

        return hillsRepository.findAll().stream()
                .filter(x->x.getHeight()>=fromChanged && x.getHeight()<=toChanged)
                .collect(Collectors.toList());
    }

    @Override
    public List<Hill> getHillsInRangeWithCountryId(int from, int to, Integer countryId) {
       
        int fromChanged = Math.abs(from);
        int toChanged = Math.abs(to);

        return  countryRepository.getOne(countryId).getHillsList().stream()
                .filter(x->x.getHeight()>=fromChanged && x.getHeight()<=toChanged)
                .collect(Collectors.toList());
    }

    
}
