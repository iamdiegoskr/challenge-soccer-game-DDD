package com.sofka.challenge.soccergameddd.domain.soccergame.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.NumberOfGoals;

public class UpdateGoalsSoccerGame extends Command {

    private final NumberOfGoals numberOfGoals;

    public UpdateGoalsSoccerGame(NumberOfGoals numberOfGoals) {
        this.numberOfGoals = numberOfGoals;
    }

    public NumberOfGoals getNumberOfGoals() {
        return numberOfGoals;
    }
}
