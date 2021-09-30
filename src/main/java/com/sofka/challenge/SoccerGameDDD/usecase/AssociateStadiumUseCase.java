package com.sofka.challenge.SoccerGameDDD.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.SoccerGame;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.commands.AddStadium;


public class AssociateStadiumUseCase extends UseCase<RequestCommand<AddStadium>, ResponseEvents> {

    //Associate stadium to game

    @Override
    public void executeUseCase(RequestCommand<AddStadium> addStadiumRequestCommand) {

        var command = addStadiumRequestCommand.getCommand();
        var soccerGame = SoccerGame.from(command.getSoccerGameId(), retrieveEvents());

        try{
            soccerGame.addStadium(command.getStadiumId(), command.getName(), command.getCapacity(), command.getLocation());
            emit().onResponse(new ResponseEvents(soccerGame.getUncommittedChanges()));
        }catch(RuntimeException e){
            emit().onError(new BusinessException(soccerGame.identity().value(), e.getMessage()));
        }

    }
}
