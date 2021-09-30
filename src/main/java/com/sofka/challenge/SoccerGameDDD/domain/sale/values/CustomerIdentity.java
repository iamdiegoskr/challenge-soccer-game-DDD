package com.sofka.challenge.SoccerGameDDD.domain.sale.values;

import co.com.sofka.domain.generic.Identity;

public class CustomerIdentity extends Identity {

    public CustomerIdentity(){
    }

    private CustomerIdentity(String id){
        super(id);
    }

    public static CustomerIdentity of(String id){
        return new CustomerIdentity(id);
    }
}
