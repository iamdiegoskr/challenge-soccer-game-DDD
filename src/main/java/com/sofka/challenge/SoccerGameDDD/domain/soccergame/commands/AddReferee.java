package com.sofka.challenge.SoccerGameDDD.domain.soccergame.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.challenge.SoccerGameDDD.domain.shared.values.Name;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.ArbitrationCharge;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.RefereeIdentity;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.SoccerGameIdentity;

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
