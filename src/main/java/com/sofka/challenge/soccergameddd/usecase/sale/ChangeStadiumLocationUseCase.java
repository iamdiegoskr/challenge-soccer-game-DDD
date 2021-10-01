package com.sofka.challenge.soccergameddd.usecase.sale;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.challenge.soccergameddd.domain.sale.Sale;
import com.sofka.challenge.soccergameddd.domain.sale.commands.ChangeStadiumLocation;

public class ChangeStadiumLocationUseCase extends UseCase<RequestCommand<ChangeStadiumLocation>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ChangeStadiumLocation> changeStadiumLocationRequestCommand) {

        var command = changeStadiumLocationRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleIdentity(), retrieveEvents(command.getSaleIdentity().value()));

        sale.updateStadiumLocation(command.getStadiumLocation());

        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));

    }
}
