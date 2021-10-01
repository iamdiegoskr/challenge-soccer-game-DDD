package com.sofka.challenge.soccergameddd.usecase.sale;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.challenge.soccergameddd.domain.sale.Sale;
import com.sofka.challenge.soccergameddd.domain.sale.commands.UpdateNumberTickets;

public class UpdateNumberOfTickerForSaleUseCase extends UseCase<RequestCommand<UpdateNumberTickets>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateNumberTickets> updateNumberTicketsRequestCommand) {

        var command = updateNumberTicketsRequestCommand.getCommand();

        var sale = Sale.from(command.getSaleIdentity(), retrieveEvents(command.getSaleIdentity().value()));

        sale.updateNumberOfTicketsForSale(command.getNumberTickets());

        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));

    }
}
