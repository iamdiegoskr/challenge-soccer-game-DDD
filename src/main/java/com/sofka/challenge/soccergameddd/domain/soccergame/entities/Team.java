package com.sofka.challenge.soccergameddd.domain.soccergame.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.City;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.NameTeam;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.NumberOfPlayers;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.TeamIdentity;

import java.util.Objects;

public class Team extends Entity<TeamIdentity> {

    private final NameTeam nameTeam;
    private final City city;
    private NumberOfPlayers numberOfPlayers;

    public Team(TeamIdentity entityId, NameTeam nameTeam, City city, NumberOfPlayers numberOfPlayers) {
        super(entityId);
        this.nameTeam = nameTeam;
        this.city = city;
        this.numberOfPlayers = numberOfPlayers;
    }

    public void numberOfPlayersPerGame(NumberOfPlayers numberOfPlayers){
        this.numberOfPlayers = Objects.requireNonNull(numberOfPlayers);
    }

    public NameTeam nameTeam() {
        return nameTeam;
    }

    public City city() {
        return city;
    }

    public NumberOfPlayers numberOfPlayers() {
        return numberOfPlayers;
    }
}
