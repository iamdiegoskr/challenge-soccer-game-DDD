package com.sofka.challenge.SoccerGameDDD.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.SoccerGameDDD.domain.sale.values.PaymentType;
import com.sofka.challenge.SoccerGameDDD.domain.sale.values.Price;
import com.sofka.challenge.SoccerGameDDD.domain.sale.values.StadiumLocation;
import com.sofka.challenge.SoccerGameDDD.domain.sale.values.TicketIdentity;

public class TicketAdded extends DomainEvent {

    private final TicketIdentity ticketId;
    private final PaymentType paymentType;
    private final StadiumLocation stadiumLocation;
    private final  Price price;

    public TicketAdded(TicketIdentity ticketId, PaymentType paymentType, StadiumLocation stadiumLocation, Price price) {
        super("sofka.sale.ticketadded");
        this.ticketId = ticketId;
        this.paymentType = paymentType;
        this.stadiumLocation = stadiumLocation;
        this.price = price;
    }

    public TicketIdentity getTicketId() {
        return ticketId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public StadiumLocation getStadiumLocation() {
        return stadiumLocation;
    }

    public Price getPrice() {
        return price;
    }
}
