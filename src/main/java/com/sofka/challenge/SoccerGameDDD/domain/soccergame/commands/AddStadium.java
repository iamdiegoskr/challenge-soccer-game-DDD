package com.sofka.challenge.SoccerGameDDD.domain.soccergame.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.Capacity;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.Location;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.NameStadium;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.StadiumIdentity;

public class AddStadium extends Command {

    private final StadiumIdentity stadiumId;
    private final NameStadium name;
    private final Capacity capacity;
    private final Location location;

    public AddStadium(StadiumIdentity stadiumId, NameStadium name, Capacity capacity, Location location) {
        this.stadiumId = stadiumId;
        this.name = name;
        this.capacity = capacity;
        this.location = location;
    }

    public StadiumIdentity getStadiumId() {
        return stadiumId;
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
