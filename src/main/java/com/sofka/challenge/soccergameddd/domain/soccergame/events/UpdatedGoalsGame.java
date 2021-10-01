package com.sofka.challenge.soccergameddd.domain.soccergame.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.NumberOfGoals;

public class UpdatedGoalsGame extends DomainEvent {

    private final NumberOfGoals numberOfGoals;

    public UpdatedGoalsGame(NumberOfGoals numberOfGoals) {
        super("sofka.soccergame.updatedgoals");
        this.numberOfGoals = numberOfGoals;
    }

    public NumberOfGoals getNumberOfGoals() {
        return numberOfGoals;
    }
}
