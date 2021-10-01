package com.sofka.challenge.soccergameddd.domain.sale.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.challenge.soccergameddd.domain.sale.values.InvoiceIdentity;
import com.sofka.challenge.soccergameddd.domain.sale.values.Price;
import com.sofka.challenge.soccergameddd.domain.sale.values.SaleIdentity;
import com.sofka.challenge.soccergameddd.domain.shared.values.Date;

public class AddInvoice extends Command {

    private final SaleIdentity saleId;
    private final InvoiceIdentity invoiceIdentity;
    private final Price price;
    private final Date date;

    public AddInvoice(SaleIdentity saleId, InvoiceIdentity invoiceIdentity, Price price, Date date) {
        this.saleId = saleId;
        this.invoiceIdentity = invoiceIdentity;
        this.price = price;
        this.date = date;
    }

    public SaleIdentity getSaleId() {
        return saleId;
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
