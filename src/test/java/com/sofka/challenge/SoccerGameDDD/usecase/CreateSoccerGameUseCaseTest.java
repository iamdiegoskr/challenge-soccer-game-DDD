package com.sofka.challenge.SoccerGameDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.SoccerGame;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.commands.CreateSoccerGame;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.events.SoccerGameCreated;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.SoccerGameIdentity;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.Tournament;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;


class CreateSoccerGameUseCaseTest {

    @Test
    @DisplayName("Validar la creacion de un partido de futbol")
    void createSoccerGame(){

        var command = new CreateSoccerGame(
                SoccerGameIdentity.of("xxx"),
                new Tournament("premier league")
        );
        var useCase = new CreateSoccerGameUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (SoccerGameCreated) events.get(0);

        Assertions.assertTrue(Objects.nonNull(event.getSoccerGameIdentity().value()));
        Assertions.assertEquals("premier league", event.getTournament().value());

    }

}