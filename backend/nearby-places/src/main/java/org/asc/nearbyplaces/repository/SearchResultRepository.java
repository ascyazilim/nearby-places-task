package org.asc.nearbyplaces.repository;

import org.asc.nearbyplaces.entity.SearchResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchResultRepository extends JpaRepository<SearchResult, Long> {
}
