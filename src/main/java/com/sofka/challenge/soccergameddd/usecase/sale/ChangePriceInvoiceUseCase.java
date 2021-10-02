package com.sofka.challenge.soccergameddd.usecase.sale;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.challenge.soccergameddd.domain.sale.Sale;
import com.sofka.challenge.soccergameddd.domain.sale.commands.ChangePriceInvoice;

public class ChangePriceInvoiceUseCase extends UseCase<RequestCommand<ChangePriceInvoice>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ChangePriceInvoice> changePriceInvoiceRequestCommand) {

        var command = changePriceInvoiceRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleIdentity(), retrieveEvents(command.getSaleIdentity().value()));

        sale.updatePriceInvoice(command.getPrice());

        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));

    }
}
