package com.sofka.challenge.SoccerGameDDD.domain.soccergame.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.*;

public class AddStadium extends Command {

    private final SoccerGameIdentity soccerGameId;
    private final StadiumIdentity stadiumId;
    private final NameStadium name;
    private final Capacity capacity;
    private final Location location;

    public AddStadium(SoccerGameIdentity soccerGameId, StadiumIdentity stadiumId,
                      NameStadium name, Capacity capacity, Location location) {
        this.soccerGameId = soccerGameId;
        this.stadiumId = stadiumId;
        this.name = name;
        this.capacity = capacity;
        this.location = location;
    }

    public SoccerGameIdentity getSoccerGameId() {
        return soccerGameId;
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
