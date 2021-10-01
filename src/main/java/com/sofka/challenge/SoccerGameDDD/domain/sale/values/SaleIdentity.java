package com.sofka.challenge.SoccerGameDDD.domain.sale.values;

import co.com.sofka.domain.generic.Identity;

public class SaleIdentity extends Identity {

    public SaleIdentity(){
    }

    private SaleIdentity(String id){
        super(id);
    }

    public static SaleIdentity of(String id){
        return new SaleIdentity(id);
    }
}
