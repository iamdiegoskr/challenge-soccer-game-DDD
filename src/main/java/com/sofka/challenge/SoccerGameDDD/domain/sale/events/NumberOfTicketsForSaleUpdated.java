package com.sofka.challenge.SoccerGameDDD.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.SoccerGameDDD.domain.sale.values.NumberOfTicketsForSale;

public class NumberOfTicketsForSaleUpdated extends DomainEvent {

    private final NumberOfTicketsForSale numberOfTicketsForSale;

    public NumberOfTicketsForSaleUpdated(NumberOfTicketsForSale numberOfTicketsForSale) {
        super("sofka.sale.numberofticketsupdated");
        this.numberOfTicketsForSale = numberOfTicketsForSale;
    }

    public NumberOfTicketsForSale getNumberOfTicketsForSale() {
        return numberOfTicketsForSale;
    }
}
