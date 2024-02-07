package org.asc.nearbyplaces.repository;

import org.asc.nearbyplaces.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findByPlaceId(String placeId);
}
