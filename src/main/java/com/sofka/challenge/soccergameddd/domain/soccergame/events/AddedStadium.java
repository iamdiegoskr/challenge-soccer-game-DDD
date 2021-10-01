package com.sofka.challenge.soccergameddd.domain.soccergame.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.Capacity;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.Location;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.NameStadium;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.StadiumIdentity;

public class AddedStadium extends DomainEvent {

    private final StadiumIdentity stadiumIdentity;
    private final NameStadium name;
    private final Capacity capacity;
    private final Location location;

    public AddedStadium(StadiumIdentity stadiumIdentity, NameStadium name, Capacity capacity, Location location) {
        super("sofka.stadium.stadiumadded");

        this.stadiumIdentity = stadiumIdentity;
        this.name = name;
        this.capacity = capacity;
        this.location = location;
    }

    public StadiumIdentity getStadiumIdentity() {
        return stadiumIdentity;
    }

    public NameStadium getName() {
        return name;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public Location getLocation() {
        return location;
    }
}
