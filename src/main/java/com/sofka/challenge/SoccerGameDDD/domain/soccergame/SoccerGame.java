package com.sofka.challenge.SoccerGameDDD.domain.soccergame;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.entities.Referee;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.entities.Schedule;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.entities.Stadium;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.entities.Team;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.events.AddedStadium;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.events.AddedTeam;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.events.SoccerGameCreated;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class SoccerGame extends AggregateEvent<SoccerGameIdentity> {

    protected Stadium stadium;
    protected Set<Team> teams;
    protected Set<Referee> referees;
    protected Schedule schedule;
    protected Tournament tournament;


    public SoccerGame(SoccerGameIdentity soccerGameIdentity, Tournament tournament) {
        super(soccerGameIdentity);
        appendChange(new SoccerGameCreated(soccerGameIdentity,tournament)).apply();
    }

    private SoccerGame(SoccerGameIdentity soccerGameIdentity){
        super(soccerGameIdentity);
        subscribe(new SoccerGameChange(this));
    }

    public static SoccerGame from(SoccerGameIdentity soccerGameIdentity, List<DomainEvent> events){
        var game = new SoccerGame(soccerGameIdentity);
        events.forEach(game::applyEvent);
        return game;
    }


    public void addStadium(StadiumIdentity stadiumId, NameStadium name, Capacity capacity,Location location){
        Objects.requireNonNull(stadiumId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(capacity);
        Objects.requireNonNull(location);
        appendChange(new AddedStadium(stadiumId,name,capacity,location)).apply();
    }

    public void addTeam(TeamIdentity teamId, NameTeam name, City city, NumberOfPlayers numberOfPlayers ){
        Objects.requireNonNull(teamId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(city);
        Objects.requireNonNull(numberOfPlayers);
        appendChange(new AddedTeam(teamId,name,city,numberOfPlayers)).apply();
    }




}
