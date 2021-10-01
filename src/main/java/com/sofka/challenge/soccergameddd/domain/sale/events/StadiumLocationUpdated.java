package com.sofka.challenge.soccergameddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.soccergameddd.domain.sale.values.StadiumLocation;

public class StadiumLocationUpdated extends DomainEvent {

    private final StadiumLocation location;

    public StadiumLocationUpdated(StadiumLocation stadiumLocation) {
        super("sofka.sales.locationupdated");
        this.location = stadiumLocation;
    }

    public StadiumLocation getLocation() {
        return location;
    }
}
