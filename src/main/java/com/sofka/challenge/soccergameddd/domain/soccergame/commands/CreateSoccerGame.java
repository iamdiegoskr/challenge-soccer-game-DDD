package com.sofka.challenge.soccergameddd.domain.soccergame.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.SoccerGameIdentity;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.Tournament;

public class CreateSoccerGame extends Command {

    private final SoccerGameIdentity soccerGameIdentity;
    private final  Tournament tournament;

    public CreateSoccerGame(SoccerGameIdentity soccerGameIdentity, Tournament tournament) {
        this.soccerGameIdentity = soccerGameIdentity;
        this.tournament = tournament;
    }

    public SoccerGameIdentity getSoccerGameIdentity() {
        return soccerGameIdentity;
    }

    public Tournament getTournament() {
        return tournament;
    }
}
