package com.sofka.challenge.soccergameddd.domain.sale.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.challenge.soccergameddd.domain.sale.values.NumberOfTicketsForSale;
import com.sofka.challenge.soccergameddd.domain.sale.values.SaleIdentity;

public class UpdateNumberTickets extends Command {

    private final SaleIdentity saleIdentity;
    private final NumberOfTicketsForSale numberTickets;

    public UpdateNumberTickets(SaleIdentity saleIdentity, NumberOfTicketsForSale numberTickets) {
        this.saleIdentity = saleIdentity;
        this.numberTickets = numberTickets;
    }

    public SaleIdentity getSaleIdentity() {
        return saleIdentity;
    }

    public NumberOfTicketsForSale getNumberTickets() {
        return numberTickets;
    }
}
