package com.geolocation.geolocation.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolocation.geolocation.model.City;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.InputStream;
import java.util.List;

@Service
public class CityService {

    private List<City> cities;

    @PostConstruct
    public void loadCities() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = getClass().getResourceAsStream("/cities.json");
        cities = mapper.readValue(is, new TypeReference<List<City>>() {});
    }

    public List<City> getAllCities() {
        return cities;
    }

    public City findByLatLong(double latitude, double longitude) {
        return cities.stream()
                .filter(city -> Math.abs(city.getLatitude() - latitude) < 0.01 &&
                        Math.abs(city.getLongitude() - longitude) < 0.01)
                .findFirst()
                .orElse(null);
    }
}
