package com.sofka.challenge.soccergameddd.domain.sale.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.challenge.soccergameddd.domain.sale.values.InvoiceIdentity;
import com.sofka.challenge.soccergameddd.domain.sale.values.Price;
import com.sofka.challenge.soccergameddd.domain.sale.values.SaleIdentity;

public class ChangePriceInvoice extends Command {

    private final SaleIdentity saleIdentity;
    private final InvoiceIdentity invoiceIdentity;
    private final Price price;

    public ChangePriceInvoice(SaleIdentity saleIdentity, InvoiceIdentity invoiceIdentity, Price price) {
        this.saleIdentity = saleIdentity;
        this.invoiceIdentity = invoiceIdentity;
        this.price = price;
    }

    public SaleIdentity getSaleIdentity() {
        return saleIdentity;
    }

    public InvoiceIdentity getInvoiceIdentity() {
        return invoiceIdentity;
    }

    public Price getPrice() {
        return price;
    }
}
