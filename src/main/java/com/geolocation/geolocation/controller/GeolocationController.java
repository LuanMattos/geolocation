package com.geolocation.geolocation.controller;

import com.geolocation.geolocation.model.City;
import com.geolocation.geolocation.repository.CityRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/geolocation")
public class GeolocationController {

    private final CityRepository cityRepository;

    public GeolocationController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public City getCityByLatLong(@RequestParam double lat, @RequestParam double lon) {
        City city = cityRepository.findByLatLong(lat, lon);
        if (city == null) {
            throw new RuntimeException("Cidade não encontrada.");
        }
        return city;
    }
}
