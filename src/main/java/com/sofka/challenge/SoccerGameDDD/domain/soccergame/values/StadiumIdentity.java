package com.sofka.challenge.SoccerGameDDD.domain.soccergame.values;

import co.com.sofka.domain.generic.Identity;

public class StadiumIdentity extends Identity {

    public StadiumIdentity(){
    }

    private StadiumIdentity(String id){
        super(id);
    }

    public static StadiumIdentity  of(String id){
        return new StadiumIdentity(id);
    }
}
