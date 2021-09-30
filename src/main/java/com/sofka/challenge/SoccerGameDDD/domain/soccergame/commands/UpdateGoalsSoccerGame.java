package com.sofka.challenge.SoccerGameDDD.domain.soccergame.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.NumberOfGoals;

public class UpdateGoalsSoccerGame extends Command {

    private final NumberOfGoals numberOfGoals;

    public UpdateGoalsSoccerGame(NumberOfGoals numberOfGoals) {
        this.numberOfGoals = numberOfGoals;
    }

    public NumberOfGoals getNumberOfGoals() {
        return numberOfGoals;
    }
}
