package com.sofka.challenge.SoccerGameDDD.domain.sale.values;

import co.com.sofka.domain.generic.Identity;

public class InvoiceIdentity extends Identity {

    public InvoiceIdentity(){
    }

    private InvoiceIdentity(String id){
        super(id);
    }

    public static InvoiceIdentity of(String id){
        return new InvoiceIdentity(id);
    }

}
