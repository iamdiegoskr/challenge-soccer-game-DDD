package com.sofka.challenge.SoccerGameDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.SoccerGameDDD.domain.shared.values.Name;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.commands.AddReferee;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.commands.AddTeam;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.events.AddedReferee;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.events.AddedTeam;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.events.SoccerGameCreated;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AssignRefereeUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void associateReferee(){

        var soccerGameID = SoccerGameIdentity.of("xxx");
        var nameTournament = new Tournament("Liga de francia");

        var refereeIdentity =  RefereeIdentity.of("yyy");
        var nameReferee = new Name("Juan Diego");
        var arbitrationCharge = new ArbitrationCharge("arbitro principal");

        var command = new AddReferee(
                soccerGameID,
                refereeIdentity,
                nameReferee,
                arbitrationCharge
        );

        var useCase = new AssignRefereeUseCase();

        Mockito.when(repository.getEventsBy(soccerGameID.value())).thenReturn(eventStored(soccerGameID,nameTournament));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(soccerGameID.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (AddedReferee) events.get(0);

        Assertions.assertEquals("xxx", event.aggregateRootId());
        Assertions.assertEquals("Juan Diego", event.getName().value());
        Assertions.assertEquals("arbitro principal", event.getArbitrationCharge().value());
    }

    private List<DomainEvent> eventStored(SoccerGameIdentity soccerGameId, Tournament tournament) {

        return List.of(
                new SoccerGameCreated(soccerGameId,tournament)
        );
    }


}