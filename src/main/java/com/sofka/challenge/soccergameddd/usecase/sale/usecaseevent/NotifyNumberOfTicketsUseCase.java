package com.sofka.challenge.soccergameddd.usecase.sale.usecaseevent;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.challenge.soccergameddd.domain.sale.Sale;
import com.sofka.challenge.soccergameddd.domain.sale.events.NumberOfTicketsForSaleUpdated;
import com.sofka.challenge.soccergameddd.domain.sale.values.SaleIdentity;

public class NotifyNumberOfTicketsUseCase extends UseCase<TriggeredEvent<NumberOfTicketsForSaleUpdated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<NumberOfTicketsForSaleUpdated> numberOfTicketsForSaleUpdatedTriggeredEvent) {

        var event = numberOfTicketsForSaleUpdatedTriggeredEvent.getDomainEvent();

        var sale = Sale.from(SaleIdentity.of(event.aggregateRootId()),this.retrieveEvents());

        sale.notifyNumberOfTickets("120000");

        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));

    }
}
