package org.asc.nearbyplaces.controller;

import lombok.RequiredArgsConstructor;
import org.asc.nearbyplaces.component.IGooglePlacesComponent;
import org.asc.nearbyplaces.entity.Location;
import org.asc.nearbyplaces.service.ILocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.asc.nearbyplaces.constants.ApiUrl.BASE_URL;
import static org.asc.nearbyplaces.constants.ApiUrl.SEARCH;

@RestController
@RequestMapping(BASE_URL)
@RequiredArgsConstructor
@CrossOrigin
public class LocationController {
    private final ILocationService locationService;
    private final IGooglePlacesComponent googlePlacesComponent;

    @GetMapping(SEARCH)
    public ResponseEntity<String> getNearbySearch(@RequestParam("lat") Double latitude,
                                                  @RequestParam("long") Double longitude,
                                                  @RequestParam("r") Integer radius) {
        Optional<Location> optionalLocation = locationService.findLocation(latitude, longitude, radius);
        Location location;
        if(optionalLocation.isPresent())
            location = optionalLocation.get();
        else
            location = locationService.saveLocation(latitude, longitude, radius);
        return ResponseEntity.ok(googlePlacesComponent.searchNearby(location));
    }
}
