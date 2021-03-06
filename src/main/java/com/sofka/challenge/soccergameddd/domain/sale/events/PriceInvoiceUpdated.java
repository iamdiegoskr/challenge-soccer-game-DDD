package com.sofka.challenge.soccergameddd.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.soccergameddd.domain.sale.values.Price;

public class PriceInvoiceUpdated extends DomainEvent {

    private final Price price;
    public PriceInvoiceUpdated(Price price) {
        super("sofka.sale.priceinvoiceupdated");
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }
}
