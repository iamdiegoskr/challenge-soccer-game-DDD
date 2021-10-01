package com.sofka.challenge.soccergameddd.domain.sale.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.challenge.soccergameddd.domain.sale.values.*;

public class AddTicket extends Command {

    private final SaleIdentity saleId;
    private final TicketIdentity ticketId;
    private final PaymentType paymentType;
    private final StadiumLocation stadiumLocation;
    private final Price price;

    public AddTicket(SaleIdentity saleId,TicketIdentity ticketId, PaymentType paymentType,
                     StadiumLocation stadiumLocation, Price price) {
        this.saleId = saleId;
        this.ticketId = ticketId;
        this.paymentType = paymentType;
        this.stadiumLocation = stadiumLocation;
        this.price = price;
    }

    public SaleIdentity getSaleId() {
        return saleId;
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
