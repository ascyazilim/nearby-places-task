package org.asc.nearbyplaces.repository;

import org.asc.nearbyplaces.entity.SearchRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchRequestRepository extends JpaRepository<SearchRequest, Long> {
}
