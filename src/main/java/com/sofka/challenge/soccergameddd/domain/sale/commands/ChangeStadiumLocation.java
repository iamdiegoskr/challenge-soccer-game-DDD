package com.sofka.challenge.soccergameddd.domain.sale.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.challenge.soccergameddd.domain.sale.values.SaleIdentity;
import com.sofka.challenge.soccergameddd.domain.sale.values.StadiumLocation;
import com.sofka.challenge.soccergameddd.domain.sale.values.TicketIdentity;

public class ChangeStadiumLocation extends Command {

    private SaleIdentity saleIdentity;
    private final StadiumLocation stadiumLocation;
    private final TicketIdentity ticketIdentity;

    public ChangeStadiumLocation(SaleIdentity saleIdentity, TicketIdentity ticketIdentity,
                                 StadiumLocation stadiumLocation) {
        this.saleIdentity = saleIdentity;
        this.ticketIdentity = ticketIdentity;
        this.stadiumLocation = stadiumLocation;
    }

    public TicketIdentity getTicketIdentity() {
        return ticketIdentity;
    }

    public SaleIdentity getSaleIdentity() {
        return saleIdentity;
    }

    public StadiumLocation getStadiumLocation() {
        return stadiumLocation;
    }
}
