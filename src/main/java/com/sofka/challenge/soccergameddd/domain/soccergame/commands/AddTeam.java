package com.sofka.challenge.soccergameddd.domain.soccergame.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.*;

public class AddTeam extends Command {

    private final SoccerGameIdentity soccerGameId;
    private final TeamIdentity teamId;
    private final NameTeam name;
    private final City city;
    private final NumberOfPlayers numberOfPlayers;

    public AddTeam(SoccerGameIdentity soccerGameId,
                   TeamIdentity teamId, NameTeam name, City city, NumberOfPlayers numberOfPlayers) {
        this.soccerGameId = soccerGameId;
        this.teamId = teamId;
        this.name = name;
        this.city = city;
        this.numberOfPlayers = numberOfPlayers;
    }

    public SoccerGameIdentity getSoccerGameId() {
        return soccerGameId;
    }

    public TeamIdentity getTeamId() {
        return teamId;
    }

    public NameTeam getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public NumberOfPlayers getNumberOfPlayers() {
        return numberOfPlayers;
    }
}
