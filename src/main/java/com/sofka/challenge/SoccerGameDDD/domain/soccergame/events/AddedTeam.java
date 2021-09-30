package com.sofka.challenge.SoccerGameDDD.domain.soccergame.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.City;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.NameTeam;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.NumberOfPlayers;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.TeamIdentity;

public class AddedTeam extends DomainEvent {

    private final TeamIdentity teamId;
    private final NameTeam nameTeam;
    private final City city;
    private final NumberOfPlayers numberOfPlayers;

    public AddedTeam(TeamIdentity teamId, NameTeam nameTeam, City city, NumberOfPlayers numberOfPlayers) {
        super("sofka.team.teamadded");
        this.teamId = teamId;
        this.nameTeam = nameTeam;
        this.city = city;
        this.numberOfPlayers = numberOfPlayers;
    }

    public TeamIdentity getTeamId() {
        return teamId;
    }

    public NameTeam getNameTeam() {
        return nameTeam;
    }

    public City getCity() {
        return city;
    }

    public NumberOfPlayers getNumberOfPlayers() {
        return numberOfPlayers;
    }
}
