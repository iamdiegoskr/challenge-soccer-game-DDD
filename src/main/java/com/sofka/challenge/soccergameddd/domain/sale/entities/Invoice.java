package com.sofka.challenge.soccergameddd.domain.sale.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.challenge.soccergameddd.domain.sale.values.InvoiceIdentity;
import com.sofka.challenge.soccergameddd.domain.sale.values.Price;
import com.sofka.challenge.soccergameddd.domain.shared.values.Date;

import java.util.Objects;

public class Invoice extends Entity<InvoiceIdentity> {

    private Price price;
    private final Date date;

    public Invoice(InvoiceIdentity entityId, Price price, Date date) {
        super(entityId);
        this.price = price;
        this.date = date;
    }

    public void updatePrice(Price price){
        this.price = Objects.requireNonNull(price);
    }

    public Price price() {
        return price;
    }

    public Date date() {
        return date;
    }
}
