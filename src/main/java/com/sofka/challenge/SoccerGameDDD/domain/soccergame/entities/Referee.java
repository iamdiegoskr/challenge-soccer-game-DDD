package com.sofka.challenge.SoccerGameDDD.domain.soccergame.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.challenge.SoccerGameDDD.domain.shared.values.Name;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.RefereeIdentity;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.ReportGame;

import java.util.Objects;

public class Referee extends Entity<RefereeIdentity> {

    private final Name name;
    private ReportGame reportGame;

    public Referee(RefereeIdentity entityId, Name name) {
        super(entityId);
        this.name = name;
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
}
