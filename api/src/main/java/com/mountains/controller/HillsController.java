package com.mountains.controller;

import com.mountains.models.Hill;
import com.mountains.services.HillService;
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
@RequestMapping("/hills")
public class HillsController {
    private final HillService hillService;

    @Autowired
    public HillsController(HillService hillService) {
        this.hillService = hillService;
    }

    @GetMapping
    public List<Hill> getAll(){
        return hillService.getAllHills();
    }

    @GetMapping("/country/{countryId}")
    public List<Hill> getAllByCountryId(@PathVariable Integer countryId){
        List<Hill> colectHills;

        try {
          colectHills =  hillService.getHillsByCountryId(countryId);
         } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Country with id %d was not found ", countryId));
         }
        return colectHills;

    }

    @GetMapping("/range/{from}/{to}")
    public List<Hill> getAllHillsInRange(@PathVariable int from, @PathVariable int to){
        return hillService.getHillsInRange(from,to);
    }

    @GetMapping("/range/{from}/{to}/{countryId}")
    public List<Hill> getAllHillsInRangeAndCountry(@PathVariable int from, @PathVariable int to, @PathVariable Integer countryId){
        return hillService.getHillsInRangeWithCountryId(from, to, countryId);

    }
}
