package com.sofka.challenge.SoccerGameDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.SoccerGameDDD.domain.shared.values.Date;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.commands.AddSchedule;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.events.AddedSchedule;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.events.SoccerGameCreated;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;



@ExtendWith(MockitoExtension.class)
class AssignScheduleUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void addScheduleGame(){


        var soccerGameID = SoccerGameIdentity.of("xxx");
        var nameTournament = new Tournament("Champions league");

        var scheduleIdentity =  ScheduleIdentity.of("yyy");
        var hourGame = new Hour("1:00 PM");
        var dateGame = new Date("2021-10-02");

        var command = new AddSchedule(
                soccerGameID,
                scheduleIdentity,
                hourGame,
                dateGame
        );

        var useCase = new AssignScheduleUseCase();

        Mockito.when(repository.getEventsBy(soccerGameID.value())).thenReturn(eventStored(soccerGameID,nameTournament));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(soccerGameID.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (AddedSchedule) events.get(0);

        Assertions.assertEquals("xxx", event.aggregateRootId());
        Assertions.assertEquals("1:00 PM", event.getHour().value());
        Assertions.assertEquals("2021-10-02", event.getDate().value());


    }

    private List<DomainEvent> eventStored(SoccerGameIdentity soccerGameId, Tournament tournament) {

        return List.of(
                new SoccerGameCreated(soccerGameId,tournament)
        );
    }


}