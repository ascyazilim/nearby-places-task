package org.asc.nearbyplaces.dto;

import lombok.Data;

@Data
public class SearchRequestDTO {
    private double longitude;
    private double latitude;
    private double radius;
}
