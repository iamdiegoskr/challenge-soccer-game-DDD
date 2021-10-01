package com.sofka.challenge.soccergameddd.domain.soccergame.values;

import co.com.sofka.domain.generic.Identity;

public class ScheduleIdentity extends Identity {

    public ScheduleIdentity(){
    }

    private ScheduleIdentity(String id){
        super(id);
    }

    public static ScheduleIdentity  of(String id){
        return new ScheduleIdentity(id);
    }

}
