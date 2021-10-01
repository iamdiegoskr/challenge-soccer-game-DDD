package com.sofka.challenge.soccergameddd.domain.soccergame.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.soccergameddd.domain.shared.values.Name;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.ArbitrationCharge;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.RefereeIdentity;

public class AddedReferee extends DomainEvent {

    private final RefereeIdentity refereeId;
    private final Name name;
    private final ArbitrationCharge arbitrationCharge;

    public AddedReferee(RefereeIdentity refereeId, Name name, ArbitrationCharge arbitrationCharge) {
        super("sofka.referee.refereeadded");
        this.refereeId = refereeId;
        this.name = name;
        this.arbitrationCharge = arbitrationCharge;
    }

    public RefereeIdentity getRefereeId() {
        return refereeId;
    }

    public Name getName() {
        return name;
    }

    public ArbitrationCharge getArbitrationCharge() {
        return arbitrationCharge;
    }
}
