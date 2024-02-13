package org.asc.nearbyplaces.component.impl;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.asc.nearbyplaces.component.IGooglePlacesComponent;
import org.asc.nearbyplaces.entity.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.asc.nearbyplaces.constants.Query.*;

@RequiredArgsConstructor
@Component
public class GooglePlacesComponentImpl implements IGooglePlacesComponent {

    private final RestTemplate restTemplate;
    @Value("${google.api.key}")
    private String apiKey;
    @Value("${google.api.url}")
    private String apiUrl;
    @Value("${google.api.scheme}")
    private String apiScheme;

    @Override
    public String searchNearby(Location location) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(this.getRootUri(location), String.class);
        return responseEntity.getBody();
    }
    private String getRootUri(Location location) {

        String url = UriComponentsBuilder
                .newInstance()
                .scheme(apiScheme)
                .host(apiUrl)
                .queryParam(LOCATION, location.getLatitude() + "," + location.getLongitude())
                .queryParam(RADIUS, location.getRadius())
                .queryParam(KEY, apiKey)
                .build()
                .toUriString();

        System.out.println(url);
        return url;
    }

}