package com.sofka.challenge.soccergameddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;

public class NumberOfTicketsNotified extends DomainEvent {

    private final String numberOfTickesMessage;

    public NumberOfTicketsNotified(String numberOfTickesMessage) {
        super("sofka.sale.numberticktsnotified");
        this.numberOfTickesMessage = numberOfTickesMessage;
    }

    public String getNumberOfTickesMessage() {
        return numberOfTickesMessage;
    }
}
