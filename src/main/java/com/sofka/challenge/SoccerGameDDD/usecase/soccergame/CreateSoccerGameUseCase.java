package com.sofka.challenge.SoccerGameDDD.usecase.soccergame;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.SoccerGame;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.commands.CreateSoccerGame;

public class CreateSoccerGameUseCase extends  UseCase<RequestCommand<CreateSoccerGame>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CreateSoccerGame> createSoccerGameRequestCommand) {

        var command = createSoccerGameRequestCommand.getCommand();

        var soccerGame = new SoccerGame(command.getSoccerGameIdentity(),command.getTournament());

        emit().onResponse(new ResponseEvents(soccerGame.getUncommittedChanges()));

    }
}
