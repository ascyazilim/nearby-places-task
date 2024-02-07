package org.asc.nearbyplaces.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class SearchRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double longitude;
    private double latitude;
    private double radius;

    @OneToMany(mappedBy = "searchRequest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SearchResult> searchResults;

}
