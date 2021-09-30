package com.sofka.challenge.SoccerGameDDD.domain.soccergame.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.City;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.NameTeam;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.NumberOfPlayers;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.TeamIdentity;

public class AddTeam extends Command {

    private final TeamIdentity teamId;
    private final NameTeam name;
    private final City city;
    private final NumberOfPlayers numberOfPlayers;

    public AddTeam(TeamIdentity teamId, NameTeam name, City city, NumberOfPlayers numberOfPlayers) {
        this.teamId = teamId;
        this.name = name;
        this.city = city;
        this.numberOfPlayers = numberOfPlayers;
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
