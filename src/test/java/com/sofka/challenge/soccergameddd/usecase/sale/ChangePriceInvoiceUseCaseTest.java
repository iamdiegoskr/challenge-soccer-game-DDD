package com.sofka.challenge.soccergameddd.usecase.sale;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.soccergameddd.domain.sale.commands.ChangePriceInvoice;
import com.sofka.challenge.soccergameddd.domain.sale.events.*;
import com.sofka.challenge.soccergameddd.domain.sale.values.*;
import com.sofka.challenge.soccergameddd.domain.shared.values.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChangePriceInvoiceUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Validar que el precio de la factura sea modificado")
    void changePriceInvoice(){

        var saleId = "xxx";
        var invoiceId ="yyy";

        var command = new ChangePriceInvoice(
                SaleIdentity.of(saleId),
                InvoiceIdentity.of(invoiceId),
                new Price(120000.0)
        );

        var useCase = new ChangePriceInvoiceUseCase();

        Mockito.when(repository.getEventsBy(saleId)).thenReturn(eventStored());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(saleId)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (PriceInvoiceUpdated)events.get(0);

        assertEquals(120000, event.getPrice().value());
        Assertions.assertEquals(1, events.size());

    }

    private List<DomainEvent> eventStored() {

        var eventSaleCreated = new SaleCreated(
                SaleIdentity.of("xxx"),
                new Date("2020-10-02"),
                new NumberOfTicketsForSale(100000)
        );

        var eventInvoiceCreated = new InvoiceAdded(
                InvoiceIdentity.of("yyy"),
                new Price(100000.0),
                new Date("2010-10-02")
        );

        List<DomainEvent> listEventsDomain = new ArrayList<>();
        listEventsDomain.add(eventSaleCreated);
        listEventsDomain.add(eventInvoiceCreated);

        return listEventsDomain;
    }

}