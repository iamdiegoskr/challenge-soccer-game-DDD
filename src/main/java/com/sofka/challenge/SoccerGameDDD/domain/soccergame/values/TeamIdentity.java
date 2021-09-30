package com.sofka.challenge.SoccerGameDDD.domain.soccergame.values;

import co.com.sofka.domain.generic.Identity;

public class TeamIdentity extends Identity {

    public TeamIdentity(){
    }

    private TeamIdentity(String id){
        super(id);
    }

    public static TeamIdentity  of(String id){
        return new TeamIdentity(id);
    }
}
