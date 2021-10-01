package com.sofka.challenge.soccergameddd.domain.soccergame.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.challenge.soccergameddd.domain.shared.values.Name;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.ArbitrationCharge;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.RefereeIdentity;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.SoccerGameIdentity;

public class AddReferee extends Command {

    private final SoccerGameIdentity soccerGameId;
    private final RefereeIdentity refereeId;
    private final Name name;
    private final ArbitrationCharge arbitrationCharge;

    public AddReferee(SoccerGameIdentity soccerGameId,RefereeIdentity refereeId, Name name,
                      ArbitrationCharge arbitrationCharge) {
        this.soccerGameId = soccerGameId;
        this.refereeId = refereeId;
        this.name = name;
        this.arbitrationCharge = arbitrationCharge;
    }

    public SoccerGameIdentity getSoccerGameId() {
        return soccerGameId;
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
