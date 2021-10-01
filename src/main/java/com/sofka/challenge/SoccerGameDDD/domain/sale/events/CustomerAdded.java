package com.sofka.challenge.SoccerGameDDD.domain.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.SoccerGameDDD.domain.sale.values.*;
import com.sofka.challenge.SoccerGameDDD.domain.shared.values.Name;

public class CustomerAdded extends DomainEvent {

    private final CustomerIdentity customerId;
    private final Name name;
    private final DateOfBirth dateOfBirth;
    private final Email email;
    private final Telephone telephone;
    private final Address address;

    public CustomerAdded(CustomerIdentity customerId, Name name, DateOfBirth dateOfBirth,
                         Email email, Telephone telephone, Address address) {
        super("sofka.sale.customeradded");
        this.customerId = customerId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
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
