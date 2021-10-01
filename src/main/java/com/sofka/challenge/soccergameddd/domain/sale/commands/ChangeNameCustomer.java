package com.sofka.challenge.soccergameddd.domain.sale.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.challenge.soccergameddd.domain.sale.values.CustomerIdentity;
import com.sofka.challenge.soccergameddd.domain.sale.values.SaleIdentity;
import com.sofka.challenge.soccergameddd.domain.shared.values.Name;

public class ChangeNameCustomer extends Command {

    private final  SaleIdentity saleIdentity;
    private final CustomerIdentity customerId;
    private final Name name;


    public ChangeNameCustomer(SaleIdentity saleIdentity,CustomerIdentity customerId, Name name) {
        this.saleIdentity = saleIdentity;
        this.customerId = customerId;
        this.name = name;
    }

    public SaleIdentity getSaleIdentity() {
        return saleIdentity;
    }

    public CustomerIdentity getCustomerId() {
        return customerId;
    }

    public Name getName() {
        return name;
    }
}
