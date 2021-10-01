package com.sofka.challenge.soccergameddd.usecase.sale;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.soccergameddd.domain.sale.commands.AddInvoice;
import com.sofka.challenge.soccergameddd.domain.sale.events.InvoiceAdded;
import com.sofka.challenge.soccergameddd.domain.sale.events.SaleCreated;
import com.sofka.challenge.soccergameddd.domain.sale.values.*;
import com.sofka.challenge.soccergameddd.domain.shared.values.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class AssignInvoiceUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Verificar que una factura este asociada a una venta")
    void assignInvoice(){

        var saleIdentity = SaleIdentity.of("xxx");
        var saleDate = new Date("2020-10-02");
        var numTickets = new NumberOfTicketsForSale(50000);

        var invoiceId =  InvoiceIdentity.of("yyy");
        var price = new Price(320000.0);
        var date = new Date("2020-10-02");

        var command = new AddInvoice(
                saleIdentity,
                invoiceId,
                price,
                date
        );

        var useCase = new AssignInvoiceUseCase();

        Mockito.when(repository.getEventsBy(saleIdentity.value())).thenReturn(eventStored(saleIdentity,
                saleDate,numTickets));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(saleIdentity.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (InvoiceAdded) events.get(0);

        Assertions.assertEquals("xxx", event.aggregateRootId());
        Assertions.assertEquals(320000, event.getPrice().value());
        Assertions.assertEquals("2020-10-02", event.getDate().value());
        Mockito.verify(repository).getEventsBy(saleIdentity.value());


    }

    private List<DomainEvent> eventStored(SaleIdentity saleId, Date date, NumberOfTicketsForSale numberTickets) {

        return List.of(
                new SaleCreated(saleId,date,numberTickets)
        );
    }

}