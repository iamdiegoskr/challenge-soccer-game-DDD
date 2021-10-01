package com.sofka.challenge.soccergameddd.usecase.sale;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.challenge.soccergameddd.domain.sale.Sale;
import com.sofka.challenge.soccergameddd.domain.sale.commands.ChangeNameCustomer;

public class ChangeNameCustomerUseCase extends UseCase<RequestCommand<ChangeNameCustomer>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ChangeNameCustomer> changeNameCustomerRequestCommand) {

        var command = changeNameCustomerRequestCommand.getCommand();

        var sale = Sale.from(command.getSaleIdentity(), retrieveEvents(command.getSaleIdentity().value()));

        sale.updateNameCustomer(command.getName());

        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));

    }
}
