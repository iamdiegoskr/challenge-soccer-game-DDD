package com.sofka.challenge.soccergameddd.domain.soccergame.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.SoccerGameIdentity;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.Tournament;

public class SoccerGameCreated extends DomainEvent {

    private final SoccerGameIdentity soccerGameIdentity;
    private final Tournament tournament;

    public SoccerGameCreated(SoccerGameIdentity soccerGameIdentity, Tournament tournament) {
        super("sofka.soccergame.gamecreated");
        this.soccerGameIdentity = soccerGameIdentity;
        this.tournament = tournament;
    }

    public SoccerGameIdentity getSoccerGameIdentity() {
        return soccerGameIdentity;
    }

    public Tournament getTournament() {
        return tournament;
    }
}
