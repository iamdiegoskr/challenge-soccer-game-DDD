package com.sofka.challenge.soccergameddd.domain.soccergame.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.Capacity;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.Location;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.NameStadium;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.StadiumIdentity;

import java.util.Objects;

public class Stadium extends Entity<StadiumIdentity> {

    private final NameStadium name;
    private final Location location;
    private Capacity capacity;


    public Stadium(StadiumIdentity stadiumIdentity, NameStadium name, Capacity capacity, Location location) {
        super(stadiumIdentity);
        this.name = name;
        this.capacity = capacity;
        this.location = location;
    }

    public void UpdateStadiumCapacity(Capacity capacity){
        this.capacity = Objects.requireNonNull(capacity);
    }

    public NameStadium name() {
        return name;
    }

    public Capacity capacity() {
        return capacity;
    }

    public Location location() {
        return location;
    }
}
