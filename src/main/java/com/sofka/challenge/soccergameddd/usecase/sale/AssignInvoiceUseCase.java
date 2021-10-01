package com.sofka.challenge.soccergameddd.usecase.sale;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.challenge.soccergameddd.domain.sale.Sale;
import com.sofka.challenge.soccergameddd.domain.sale.commands.AddInvoice;

public class AssignInvoiceUseCase extends UseCase<RequestCommand<AddInvoice>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddInvoice> addInvoiceRequestCommand) {

        var command = addInvoiceRequestCommand.getCommand();
        var sale =  Sale.from(command.getSaleId(), retrieveEvents());

        try{
            sale.addInvoice(command.getInvoiceIdentity(),command.getPrice(),command.getDate());
            emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
        }catch(RuntimeException e){
            emit().onError(new BusinessException(sale.identity().value(), e.getMessage()));
        }

    }
}
