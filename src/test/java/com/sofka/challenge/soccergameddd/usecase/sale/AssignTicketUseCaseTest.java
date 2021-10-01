package com.sofka.challenge.soccergameddd.usecase.sale;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.soccergameddd.domain.sale.commands.AddCustomer;
import com.sofka.challenge.soccergameddd.domain.sale.commands.AddTicket;
import com.sofka.challenge.soccergameddd.domain.sale.events.CustomerAdded;
import com.sofka.challenge.soccergameddd.domain.sale.events.SaleCreated;
import com.sofka.challenge.soccergameddd.domain.sale.events.TicketAdded;
import com.sofka.challenge.soccergameddd.domain.sale.values.*;
import com.sofka.challenge.soccergameddd.domain.shared.values.Date;
import com.sofka.challenge.soccergameddd.domain.shared.values.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;



@ExtendWith(MockitoExtension.class)
class AssignTicketUseCaseTest {

    @Mock
    private DomainEventRepository repository;


    @Test
    @DisplayName("Validar que un ticket este asociado a una venta")
    void assignTicket(){

        var saleIdentity = SaleIdentity.of("xxx");
        var saleDate = new Date("2020-10-02");
        var numTickets = new NumberOfTicketsForSale(50000);

        var ticketIdentity =  TicketIdentity.of("yyy");
        var paymentType = new PaymentType("efectivo");
        var stadiumLocation = new StadiumLocation("norte");
        var price = new Price(80000.0);


        var command = new AddTicket(
                saleIdentity,
                ticketIdentity,
                paymentType,
                stadiumLocation,
                price
        );

        var useCase = new AssignTicketUseCase();

        Mockito.when(repository.getEventsBy(saleIdentity.value())).thenReturn(eventStored(saleIdentity,
                saleDate,numTickets));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(saleIdentity.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (TicketAdded) events.get(0);


        Assertions.assertEquals("xxx", event.aggregateRootId());
        Assertions.assertEquals("efectivo", event.getPaymentType().value());
        Assertions.assertEquals("norte", event.getStadiumLocation().value());
        Assertions.assertEquals(80000, event.getPrice().value());
        Mockito.verify(repository).getEventsBy(saleIdentity.value());


    }

    private List<DomainEvent> eventStored(SaleIdentity saleId, Date date, NumberOfTicketsForSale numberTickets) {

        return List.of(
                new SaleCreated(saleId,date,numberTickets)
        );
    }

}