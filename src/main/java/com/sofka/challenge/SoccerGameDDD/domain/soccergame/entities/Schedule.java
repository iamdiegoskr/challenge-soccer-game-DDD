package com.sofka.challenge.SoccerGameDDD.domain.soccergame.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.Date;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.Hour;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.ScheduleIdentity;

import java.util.Objects;

public class Schedule extends Entity<ScheduleIdentity> {

    private Hour hour;
    private Date date;

    public Schedule(ScheduleIdentity entityId, Hour hour, Date date) {
        super(entityId);
        this.hour = hour;
        this.date = date;
    }

    public void updateHourGame(Hour hour){
        this.hour = Objects.requireNonNull(hour);
    }

    public void updateDateGame(Date date){
        this.date = Objects.requireNonNull(date);
    }

    public Hour hour() {
        return hour;
    }

    public Date date() {
        return date;
    }
}
