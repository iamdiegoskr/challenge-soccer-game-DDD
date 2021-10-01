package com.sofka.challenge.SoccerGameDDD.domain.soccergame.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.challenge.SoccerGameDDD.domain.shared.values.Date;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.Hour;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.ScheduleIdentity;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.SoccerGameIdentity;

public class AddSchedule extends Command {

    private final SoccerGameIdentity soccerGameId;
    private final ScheduleIdentity scheduleId;
    private final Hour hour;
    private final Date date;


    public AddSchedule(SoccerGameIdentity soccerGameId,ScheduleIdentity scheduleId, Hour hour, Date date) {
        this.soccerGameId = soccerGameId;
        this.scheduleId = scheduleId;
        this.hour = hour;
        this.date = date;
    }

    public SoccerGameIdentity getSoccerGameId() {
        return soccerGameId;
    }

    public ScheduleIdentity getScheduleId() {
        return scheduleId;
    }

    public Hour getHour() {
        return hour;
    }

    public Date getDate() {
        return date;
    }
}
