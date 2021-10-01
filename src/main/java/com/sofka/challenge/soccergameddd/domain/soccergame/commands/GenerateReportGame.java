package com.sofka.challenge.soccergameddd.domain.soccergame.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.ReportGame;

public class GenerateReportGame extends Command {

    private final ReportGame reportGame;

    public GenerateReportGame(ReportGame reportGame) {
        this.reportGame = reportGame;
    }

    public ReportGame getReportGame() {
        return reportGame;
    }
}
