package org.asc.nearbyplaces.service;

import org.asc.nearbyplaces.entity.Location;

import java.util.Optional;

public interface ILocationService {
    Optional<Location> findLocation(Double latitude, Double longitude, Integer radius);

    Location saveLocation(Double latitude, Double longitude, Integer radius);
}
