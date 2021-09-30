package com.sofka.challenge.SoccerGameDDD.domain.soccergame.values;

import co.com.sofka.domain.generic.Identity;

public class RefereeIdentity extends Identity {

    public RefereeIdentity(){
    }

    private RefereeIdentity(String id){
        super(id);
    }

    public static RefereeIdentity  of(String id){
        return new RefereeIdentity(id);
    }

}
