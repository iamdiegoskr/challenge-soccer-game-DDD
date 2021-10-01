package com.sofka.challenge.soccergameddd.usecase.sale;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.challenge.soccergameddd.domain.sale.Sale;
import com.sofka.challenge.soccergameddd.domain.sale.commands.CreateSale;

public class CreateSaleUseCase extends UseCase<RequestCommand<CreateSale>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateSale> createSaleRequestCommand) {

        var command = createSaleRequestCommand.getCommand();

        var sale = new Sale(command.getSaleIdentity(),command.getDate(),command.getNumberOfTicketsForSale());

        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));

    }
}
