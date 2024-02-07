package org.asc.nearbyplaces.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SearchResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placeId;
    private String name;
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "search_request_id")
    private SearchRequest searchRequest;
}
