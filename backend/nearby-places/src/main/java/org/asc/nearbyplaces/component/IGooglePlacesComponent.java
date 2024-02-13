package org.asc.nearbyplaces.component;

import org.asc.nearbyplaces.entity.Location;

public interface IGooglePlacesComponent {
    String searchNearby(Location location);
}
