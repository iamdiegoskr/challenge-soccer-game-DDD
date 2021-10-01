package com.sofka.challenge.SoccerGameDDD.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.SoccerGame;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.commands.AddSchedule;

public class AssignScheduleUseCase extends UseCase<RequestCommand<AddSchedule>, ResponseEvents> {



    @Override
    public void executeUseCase(RequestCommand<AddSchedule> addScheduleRequestCommand) {

        var command = addScheduleRequestCommand.getCommand();
        var soccerGame = SoccerGame.from(command.getSoccerGameId(), retrieveEvents());

        try{
            soccerGame.addSchedule(command.getScheduleId(),
                    command.getHour(), command.getDate());
            emit().onResponse(new ResponseEvents(soccerGame.getUncommittedChanges()));

        }catch(RuntimeException e){
            emit().onError(new BusinessException(soccerGame.identity().value(), e.getMessage()));
        }

    }
}
