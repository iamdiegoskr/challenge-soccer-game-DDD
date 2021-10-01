package com.sofka.challenge.soccergameddd.domain.sale.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.challenge.soccergameddd.domain.sale.values.NumberOfTicketsForSale;
import com.sofka.challenge.soccergameddd.domain.sale.values.SaleIdentity;
import com.sofka.challenge.soccergameddd.domain.shared.values.Date;

public class CreateSale extends Command {

    private final SaleIdentity saleIdentity;
    private final Date date;
    private final NumberOfTicketsForSale numberOfTicketsForSale;

    public CreateSale(SaleIdentity saleIdentity, Date date, NumberOfTicketsForSale numberOfTicketsForSale){
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
