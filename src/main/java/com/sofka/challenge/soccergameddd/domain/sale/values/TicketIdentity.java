package com.sofka.challenge.soccergameddd.domain.sale.values;

import co.com.sofka.domain.generic.Identity;

public class TicketIdentity extends Identity {

    public TicketIdentity(){
    }

    private TicketIdentity(String id){
        super(id);
    }

    public static TicketIdentity of(String id){
        return new TicketIdentity(id);
    }

}
