package com.sofka.challenge.soccergameddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;

public class NumberOfTicketsNotified extends DomainEvent {

    private final String numberoftickesmessage;

    public NumberOfTicketsNotified(String numberoftickesmessage) {
        super("sofka.sale.numberticktsnotified");
        this.numberoftickesmessage = numberoftickesmessage;
    }

    public String getNumberoftickesmessage() {
        return numberoftickesmessage;
    }
}
