package com.sofka.challenge.SoccerGameDDD.domain.soccergame;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.SoccerGameIdentity;

public class SoccerGame extends AggregateEvent<SoccerGameIdentity> {

    public SoccerGame(SoccerGameIdentity entityId) {
        super(entityId);
    }


}
