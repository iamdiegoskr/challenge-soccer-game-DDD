package com.sofka.challenge.soccergameddd.usecase.sale;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.challenge.soccergameddd.domain.sale.Sale;
import com.sofka.challenge.soccergameddd.domain.sale.commands.AddCustomer;


public class AssignCustomerUseCase extends UseCase<RequestCommand<AddCustomer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddCustomer> addCustomerRequestCommand) {

        var command = addCustomerRequestCommand.getCommand();

        var sale =  Sale.from(command.getSaleId(), retrieveEvents());

        try{
            sale.addCustomer(command.getCustomerId(),command.getName(),command.getDateOfBirth(),
                    command.getEmail(),command.getTelephone(),command.getAddress());
            emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
        }catch(RuntimeException e){
            emit().onError(new BusinessException(sale.identity().value(), e.getMessage()));
        }

    }
}
