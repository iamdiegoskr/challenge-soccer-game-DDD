package com.sofka.challenge.SoccerGameDDD.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.SoccerGame;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.commands.AddReferee;

public class AssignRefereeUseCase extends UseCase<RequestCommand<AddReferee>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddReferee> addRefereeRequestCommand) {

        var command = addRefereeRequestCommand.getCommand();
        var soccerGame = SoccerGame.from(command.getSoccerGameId(), retrieveEvents());

        try{
            soccerGame.addReferee(command.getRefereeId(),
                    command.getName(), command.getArbitrationCharge());
            emit().onResponse(new ResponseEvents(soccerGame.getUncommittedChanges()));

        }catch(RuntimeException e){
            emit().onError(new BusinessException(soccerGame.identity().value(), e.getMessage()));
        }

    }
}
