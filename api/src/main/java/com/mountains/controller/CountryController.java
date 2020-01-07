package com.mountains.controller;

import com.mountains.models.Country;
import com.mountains.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/country")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAll(){
        return countryService.getAll();
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable Integer id){

        Country wantedCountry;
        try {
          wantedCountry =  countryService.getCountryById(id);
         } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Country with id %d was not found ", id));
         }
   
        return wantedCountry;
    }
}
