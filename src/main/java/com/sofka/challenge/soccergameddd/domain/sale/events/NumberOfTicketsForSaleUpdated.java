package com.sofka.challenge.soccergameddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.soccergameddd.domain.sale.values.NumberOfTicketsForSale;

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
