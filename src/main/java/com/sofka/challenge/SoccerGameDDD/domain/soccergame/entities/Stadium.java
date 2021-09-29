package com.sofka.challenge.SoccerGameDDD.domain.soccergame.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.Capacity;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.Location;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.NameStadium;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.StadiumIdentity;

import java.util.Objects;

public class Stadium extends Entity<StadiumIdentity> {

    private NameStadium name;
    private Capacity capacity;
    private Location location;

    public Stadium(StadiumIdentity stadiumIdentity, NameStadium name, Capacity capacity, Location location) {
        super(stadiumIdentity);
        this.name = name;
        this.capacity = capacity;
        this.location = location;
    }

   //Comportamientos de la entidad.

    public void updateNameStadium(NameStadium name){
        this.name = Objects.requireNonNull(name);
    }

    public void updateLocationStadium(Location location){
        this.location = Objects.requireNonNull(location);
    }

    public void updateCapacity(Capacity capacity){
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
