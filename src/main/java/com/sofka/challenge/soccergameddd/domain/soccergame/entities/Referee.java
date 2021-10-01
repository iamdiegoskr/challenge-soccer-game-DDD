package com.sofka.challenge.soccergameddd.domain.soccergame.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.challenge.soccergameddd.domain.shared.values.Name;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.ArbitrationCharge;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.RefereeIdentity;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.ReportGame;

import java.util.Objects;

public class Referee extends Entity<RefereeIdentity> {

    private final Name name;
    private final ArbitrationCharge arbitrationCharge;
    private ReportGame reportGame;

    public Referee(RefereeIdentity entityId, Name name, ArbitrationCharge arbitrationCharge) {
        super(entityId);
        this.name = name;
        this.arbitrationCharge = arbitrationCharge;
    }

    public void generateReportGame(ReportGame reportGame){
        this.reportGame = Objects.requireNonNull(reportGame);
    }


    public Name getName() {
        return name;
    }

    public ReportGame getReportGame() {
        return reportGame;
    }

    public ArbitrationCharge getArbitrationCharge() {
        return arbitrationCharge;
    }
}
