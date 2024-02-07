package org.asc.nearbyplaces.dto;

import lombok.Data;

import java.util.List;

@Data
public class SearchResultDTO {

    private List<PlaceDTO> places;
}
