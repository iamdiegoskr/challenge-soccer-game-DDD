package com.sofka.challenge.soccergameddd.usecase.sale;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.challenge.soccergameddd.domain.sale.Sale;
import com.sofka.challenge.soccergameddd.domain.sale.commands.AddTicket;

public class AssignTicketUseCase extends UseCase<RequestCommand<AddTicket>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddTicket> addTicketRequestCommand) {
        var command = addTicketRequestCommand.getCommand();
        var sale =  Sale.from(command.getSaleId(), retrieveEvents());

        try{
            sale.addTicket(command.getTicketId(),command.getPaymentType(),command.getStadiumLocation(),
                    command.getPrice());
            emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
        }catch(RuntimeException e){
            emit().onError(new BusinessException(sale.identity().value(), e.getMessage()));
        }
    }
}
