package com.sofka.challenge.SoccerGameDDD.domain.sale.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.challenge.SoccerGameDDD.domain.sale.values.PaymentType;
import com.sofka.challenge.SoccerGameDDD.domain.sale.values.Price;
import com.sofka.challenge.SoccerGameDDD.domain.sale.values.StadiumLocation;
import com.sofka.challenge.SoccerGameDDD.domain.sale.values.TicketIdentity;

import java.util.Objects;

public class Ticket extends Entity<TicketIdentity> {

    private PaymentType paymentType;
    private StadiumLocation stadiumLocation;
    private Price price;


    public Ticket(TicketIdentity entityId, PaymentType paymentType, StadiumLocation stadiumLocation, Price price) {
        super(entityId);
        this.paymentType = paymentType;
        this.stadiumLocation = stadiumLocation;
        this.price = price;
    }

    public void updatePaymentType(PaymentType paymentType){
        this.paymentType = Objects.requireNonNull(paymentType);
    }

    public void updateStadiumLocation(StadiumLocation stadiumLocation){
        this.stadiumLocation = Objects.requireNonNull(stadiumLocation);
    }

    public void updatePriceTicket(Price price){
        this.price = Objects.requireNonNull(price);
    }

    public PaymentType paymentType() {
        return paymentType;
    }

    public StadiumLocation stadiumLocation() {
        return stadiumLocation;
    }

    public Price price() {
        return price;
    }
}
