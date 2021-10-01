package com.sofka.challenge.SoccerGameDDD.domain.sale.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.challenge.SoccerGameDDD.domain.sale.values.*;
import com.sofka.challenge.SoccerGameDDD.domain.shared.values.Name;

import java.util.Objects;

public class Customer extends Entity<CustomerIdentity> {

    private Name name;
    private final DateOfBirth dateOfBirth;
    private Email email;
    private Telephone telephone;
    private Address address;


    public Customer(CustomerIdentity customerId, Name name, DateOfBirth dateOfBirth,
                    Email email, Telephone telephone, Address address) {
        super(customerId);
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
    }

    public void updateNameCustomer(Name name){
        this.name = Objects.requireNonNull(name);
    }

    public void updateEmailCustomer(Email email){
        this.email = Objects.requireNonNull(email);
    }

    public void updateTelephone(Telephone telephone){
        this.telephone = Objects.requireNonNull(telephone);
    }

    public void updateAddress(Address address){
        this.address = Objects.requireNonNull(address);
    }

    public Name name() {
        return name;
    }

    public DateOfBirth dateOfBirth() {
        return dateOfBirth;
    }

    public Email email() {
        return email;
    }

    public Telephone telephone() {
        return telephone;
    }

    public Address address() {
        return address;
    }


}
