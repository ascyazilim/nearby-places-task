package org.asc.nearbyplaces.service.impl;

import jakarta.transaction.Transactional;
import org.asc.nearbyplaces.entity.Location;
import org.asc.nearbyplaces.repository.ILocationRepository;
import org.asc.nearbyplaces.service.ILocationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationServiceImpl implements ILocationService {

    private final ILocationRepository locationRepository;

    public LocationServiceImpl(ILocationRepository locationRepository) {
        super();
        this.locationRepository = locationRepository;
    }
    @Override
    @Transactional
    public Optional<Location> findLocation(Double latitude, Double longitude, Integer radius) {
        return locationRepository.findByLongitudeEqualsAndLatitudeEqualsAndRadiusEquals(longitude, latitude, radius);
    }

    @Override
    @Transactional
    public Location saveLocation(Double latitude, Double longitude, Integer radius) {
        Location location = Location.builder()
                .longitude(longitude)
                .latitude(latitude)
                .radius(radius)
                .build();
        return locationRepository.save(location);
    }
}
