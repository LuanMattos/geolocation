package com.geolocation.geolocation.repository;

import com.geolocation.geolocation.model.City;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.List;

@Repository
public class CityRepository {

    private final List<City> cities;

    public CityRepository() throws Exception {
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
