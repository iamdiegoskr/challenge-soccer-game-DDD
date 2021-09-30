package com.sofka.challenge.SoccerGameDDD.domain.soccergame;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.entities.Referee;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.entities.Schedule;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.entities.Stadium;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.entities.Team;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.events.SoccerGameCreated;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.SoccerGameIdentity;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.Tournament;

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



}
