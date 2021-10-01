package com.sofka.challenge.SoccerGameDDD.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.SoccerGameDDD.domain.shared.values.Name;

public class NameUpdated extends DomainEvent {

    private final Name name;
    public NameUpdated(Name name) {
        super("sofka.sale.updatednamecustomer");
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
