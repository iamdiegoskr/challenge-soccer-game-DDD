package com.sofka.challenge.soccergameddd.usecase.sale;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.soccergameddd.domain.sale.commands.ChangeStadiumLocation;
import com.sofka.challenge.soccergameddd.domain.sale.events.SaleCreated;
import com.sofka.challenge.soccergameddd.domain.sale.events.StadiumLocationUpdated;
import com.sofka.challenge.soccergameddd.domain.sale.events.TicketAdded;
import com.sofka.challenge.soccergameddd.domain.sale.values.*;
import com.sofka.challenge.soccergameddd.domain.shared.values.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChangeStadiumLocationUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void changeStadiumLocation(){


        var saleId = "xxx";
        var ticketId ="yyy";

        var command = new ChangeStadiumLocation(
                SaleIdentity.of(saleId),
                TicketIdentity.of(ticketId),
                new StadiumLocation("sur")
        );

        var useCase = new ChangeStadiumLocationUseCase();

        Mockito.when(repository.getEventsBy(saleId)).thenReturn(eventStored());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(saleId)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (StadiumLocationUpdated)events.get(0);

        assertEquals("sur", event.getLocation().value());
        Assertions.assertEquals(1, events.size());

    }

    private List<DomainEvent> eventStored() {

        var eventSaleCreated = new SaleCreated(
                SaleIdentity.of("xxx"),
                new Date("2020-10-02"),
                new NumberOfTicketsForSale(100000)
        );

        var eventTicketCreated = new TicketAdded(
                TicketIdentity.of("yyy"),
                new PaymentType("efectivo"),
                new StadiumLocation("norte"),
                new Price(80000.0)
        );

        List<DomainEvent> listEventsDomain = new ArrayList<>();
        listEventsDomain.add(eventSaleCreated);
        listEventsDomain.add(eventTicketCreated);

        return listEventsDomain;
    }


}