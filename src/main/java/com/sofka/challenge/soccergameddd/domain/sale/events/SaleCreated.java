package com.sofka.challenge.soccergameddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.soccergameddd.domain.sale.values.NumberOfTicketsForSale;
import com.sofka.challenge.soccergameddd.domain.sale.values.SaleIdentity;
import com.sofka.challenge.soccergameddd.domain.shared.values.Date;

public class SaleCreated extends DomainEvent {

    private final SaleIdentity saleIdentity;
    private final Date date;
    private final NumberOfTicketsForSale numberOfTicketsForSale;

    public SaleCreated(SaleIdentity saleIdentity, Date date, NumberOfTicketsForSale numberOfTicketsForSale) {
        super("sofka.sale.salecreated");
        this.saleIdentity = saleIdentity;
        this.date = date;
        this.numberOfTicketsForSale = numberOfTicketsForSale;
    }

    public SaleIdentity getSaleIdentity() {
        return saleIdentity;
    }

    public Date getDate() {
        return date;
    }

    public NumberOfTicketsForSale getNumberOfTicketsForSale() {
        return numberOfTicketsForSale;
    }
}
