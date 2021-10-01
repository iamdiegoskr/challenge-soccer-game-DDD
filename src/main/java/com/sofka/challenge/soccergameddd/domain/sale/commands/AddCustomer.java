package com.sofka.challenge.soccergameddd.domain.sale.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.challenge.soccergameddd.domain.sale.values.*;
import com.sofka.challenge.soccergameddd.domain.shared.values.Name;

public class AddCustomer extends Command {

    private final SaleIdentity saleId;
    private final CustomerIdentity customerId;
    private final Name name;
    private final DateOfBirth dateOfBirth;
    private final Email email;
    private final Telephone telephone;
    private final Address address;

    public AddCustomer(SaleIdentity saleId, CustomerIdentity customerId,
                       Name name, DateOfBirth dateOfBirth, Email email, Telephone telephone, Address address) {
        this.saleId = saleId;
        this.customerId = customerId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
    }

    public SaleIdentity getSaleId() {
        return saleId;
    }

    public CustomerIdentity getCustomerId() {
        return customerId;
    }

    public Name getName() {
        return name;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public Email getEmail() {
        return email;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    public Address getAddress() {
        return address;
    }
}
