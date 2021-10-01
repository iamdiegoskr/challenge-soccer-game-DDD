package com.sofka.challenge.SoccerGameDDD.usecase.soccergame;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.commands.AddTeam;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.events.AddedTeam;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.events.SoccerGameCreated;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.*;
import com.sofka.challenge.SoccerGameDDD.usecase.soccergame.AssignTeamUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AssignTeamUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Validar que se le asigne un equipo a un partido de futbol")
    void associateTeam(){

        var soccerGameID = SoccerGameIdentity.of("xxx");
        var nameTournament = new Tournament("Liga colombiana");
        var teamIdentity =  TeamIdentity.of("yyy");
        var nameTeam = new NameTeam("Atletico nacional");
        var cityTeam = new City("Medellin");
        var numberPlayerOfTeam = new NumberOfPlayers(25);

        var command = new AddTeam(
                soccerGameID,
                teamIdentity,
                nameTeam,
                cityTeam,
                numberPlayerOfTeam
        );

        var useCase = new AssignTeamUseCase();

        Mockito.when(repository.getEventsBy(soccerGameID.value())).thenReturn(eventStored(soccerGameID,nameTournament));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(soccerGameID.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (AddedTeam) events.get(0);

        Assertions.assertEquals("xxx", event.aggregateRootId());
        Assertions.assertEquals("Atletico nacional", event.getNameTeam().value());
        Assertions.assertEquals("Medellin", event.getCity().value());
        Assertions.assertEquals(25, event.getNumberOfPlayers().value());
        Mockito.verify(repository).getEventsBy(soccerGameID.value());
    }

    private List<DomainEvent> eventStored(SoccerGameIdentity soccerGameId, Tournament tournament) {

        return List.of(
                new SoccerGameCreated(soccerGameId,tournament)
        );
    }

}