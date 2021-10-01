package com.sofka.challenge.SoccerGameDDD.domain.soccergame.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.SoccerGameDDD.domain.shared.values.Date;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.Hour;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.ScheduleIdentity;

public class AddedSchedule extends DomainEvent {

    private final ScheduleIdentity scheduleId;
    private final Hour hour;
    private final Date date;

    public AddedSchedule(ScheduleIdentity scheduleId, Hour hour, Date date) {
        super("sofka.schedule.scheduleadded");
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
