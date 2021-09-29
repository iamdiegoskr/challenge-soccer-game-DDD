package com.sofka.challenge.SoccerGameDDD.domain.soccergame.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.StadiumIdentity;

public class Stadium extends Entity<StadiumIdentity> {

    public Stadium(StadiumIdentity entityId) {
        super(entityId);
    }
}
