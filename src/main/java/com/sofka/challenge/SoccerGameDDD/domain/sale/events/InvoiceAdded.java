package com.sofka.challenge.SoccerGameDDD.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.SoccerGameDDD.domain.sale.values.InvoiceIdentity;
import com.sofka.challenge.SoccerGameDDD.domain.sale.values.Price;
import com.sofka.challenge.SoccerGameDDD.domain.shared.values.Date;

public class InvoiceAdded extends DomainEvent {

    private final InvoiceIdentity invoiceIdentity;
    private final Price price;
    private final Date date;
    public InvoiceAdded(InvoiceIdentity invoiceIdentity, Price price, Date date) {
        super("sofka.sale.invoiceadded");
        this.invoiceIdentity = invoiceIdentity;
        this.price = price;
        this.date = date;
    }

    public InvoiceIdentity getInvoiceIdentity() {
        return invoiceIdentity;
    }

    public Price getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }
}
