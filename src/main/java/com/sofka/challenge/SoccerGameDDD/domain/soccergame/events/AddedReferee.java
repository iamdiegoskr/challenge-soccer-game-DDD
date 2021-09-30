package com.sofka.challenge.SoccerGameDDD.domain.soccergame.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.SoccerGameDDD.domain.shared.values.Name;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.RefereeIdentity;

public class AddedReferee extends DomainEvent {

    private final RefereeIdentity refereeId;
    private final Name name;

    public AddedReferee(RefereeIdentity refereeId, Name name) {
        super("sofka.referee.refereeadded");
        this.refereeId = refereeId;
        this.name = name;
    }

    public RefereeIdentity getRefereeId() {
        return refereeId;
    }

    public Name getName() {
        return name;
    }
}
