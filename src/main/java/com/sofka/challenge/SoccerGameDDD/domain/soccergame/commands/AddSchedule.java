package com.sofka.challenge.SoccerGameDDD.domain.soccergame.commands;

import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.Date;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.Hour;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.ScheduleIdentity;

public class AddSchedule {

    private final ScheduleIdentity scheduleId;
    private final Hour hour;
    private final Date date;


    public AddSchedule(ScheduleIdentity scheduleId, Hour hour, Date date) {
        this.scheduleId = scheduleId;
        this.hour = hour;
        this.date = date;
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
