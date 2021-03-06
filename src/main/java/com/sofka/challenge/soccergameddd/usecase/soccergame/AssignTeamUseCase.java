package com.sofka.challenge.soccergameddd.usecase.soccergame;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.challenge.soccergameddd.domain.soccergame.SoccerGame;
import com.sofka.challenge.soccergameddd.domain.soccergame.commands.AddTeam;

public class AssignTeamUseCase extends UseCase<RequestCommand<AddTeam>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddTeam> addTeamRequestCommand) {

        var command = addTeamRequestCommand.getCommand();
        var soccerGame = SoccerGame.from(command.getSoccerGameId(), retrieveEvents());

        try{
            soccerGame.addTeam(command.getTeamId(),
                    command.getName(), command.getCity(),command.getNumberOfPlayers());
            emit().onResponse(new ResponseEvents(soccerGame.getUncommittedChanges()));

        }catch(RuntimeException e){
            emit().onError(new BusinessException(soccerGame.identity().value(), e.getMessage()));
        }

    }
}
