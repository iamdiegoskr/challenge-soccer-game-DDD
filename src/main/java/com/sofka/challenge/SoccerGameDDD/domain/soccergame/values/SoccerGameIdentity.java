package com.sofka.challenge.SoccerGameDDD.domain.soccergame.values;

import co.com.sofka.domain.generic.Identity;

public class SoccerGameIdentity extends Identity {

    public SoccerGameIdentity(){
    }

    private SoccerGameIdentity(String id){
        super(id);
    }

    public static SoccerGameIdentity  of(String id){
        return new SoccerGameIdentity(id);
    }

}
