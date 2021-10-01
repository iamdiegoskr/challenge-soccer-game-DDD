package com.sofka.challenge.SoccerGameDDD.usecase.soccergame;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.commands.AddStadium;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.events.AddedStadium;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.events.SoccerGameCreated;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.*;
import com.sofka.challenge.SoccerGameDDD.usecase.soccergame.AssignStadiumUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AssignStadiumUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Validar que se le asigne un estadio a un partido de futbol")
    void associateStadium(){

        var soccerGameID = SoccerGameIdentity.of("xxx");
        var nameTournament = new Tournament("Liga españa");
        var stadiumID =  StadiumIdentity.of("yyy");
        var name = new NameStadium("Camp nou");
        var capacity = new Capacity(100000);
        var location = new Location("Calle 22","Barcelona","España");

        var command = new AddStadium(
                soccerGameID,
                stadiumID,
                name,
                capacity,
                location
        );

        var useCase= new AssignStadiumUseCase();

        Mockito.when(repository.getEventsBy(soccerGameID.value())).thenReturn(eventStored(soccerGameID,nameTournament));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(soccerGameID.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (AddedStadium) events.get(0);

        Assertions.assertEquals("xxx", event.aggregateRootId());
        Assertions.assertEquals("Camp nou", event.getName().value());
        Assertions.assertEquals(100000, event.getCapacity().value());
        Assertions.assertEquals("Calle 22", event.getLocation().value().street());
        Assertions.assertEquals("Barcelona", event.getLocation().value().city());
        Assertions.assertEquals("España", event.getLocation().value().country());
        Mockito.verify(repository).getEventsBy(soccerGameID.value());

    }

    private List<DomainEvent> eventStored(SoccerGameIdentity soccerGameId, Tournament tournament) {

        return List.of(
                new SoccerGameCreated(soccerGameId,tournament)
        );
    }

}