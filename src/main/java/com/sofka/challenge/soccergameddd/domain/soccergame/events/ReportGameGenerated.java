package com.sofka.challenge.soccergameddd.domain.soccergame.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.ReportGame;

public class ReportGameGenerated extends DomainEvent {
    private final ReportGame reportGame;

    public ReportGameGenerated(ReportGame reportGame) {
        super("sofka.referee.reportgamegenerated");
        this.reportGame = reportGame;
    }

    public ReportGame getReportGame() {
        return reportGame;
    }
}
