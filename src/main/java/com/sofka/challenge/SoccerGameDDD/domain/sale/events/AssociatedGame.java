package com.sofka.challenge.SoccerGameDDD.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.SoccerGameIdentity;

public class AssociatedGame extends DomainEvent {

    private final SoccerGameIdentity soccerGameIdentity;

    public AssociatedGame(SoccerGameIdentity soccerGameIdentity) {
        super("sofka.sale.associatedgame");
        this.soccerGameIdentity = soccerGameIdentity;
    }

    public SoccerGameIdentity getSoccerGameIdentity() {
        return soccerGameIdentity;
    }
}
