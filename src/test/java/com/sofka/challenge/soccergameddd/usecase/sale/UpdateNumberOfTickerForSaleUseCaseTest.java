package com.sofka.challenge.soccergameddd.usecase.sale;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.soccergameddd.domain.sale.commands.UpdateNumberTickets;
import com.sofka.challenge.soccergameddd.domain.sale.events.NumberOfTicketsForSaleUpdated;
import com.sofka.challenge.soccergameddd.domain.sale.events.SaleCreated;
import com.sofka.challenge.soccergameddd.domain.sale.values.NumberOfTicketsForSale;
import com.sofka.challenge.soccergameddd.domain.sale.values.SaleIdentity;
import com.sofka.challenge.soccergameddd.domain.shared.values.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdateNumberOfTickerForSaleUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Validar que la actualizacion de numero de ticketes para la venta funcione")
    void updateNumberTickerForSale(){

        var saleId = SaleIdentity.of("xxx");
        var date = new Date("2020-10-01");
        var numberTickets = new NumberOfTicketsForSale(100000);

        var command = new UpdateNumberTickets(
                saleId,
                new NumberOfTicketsForSale(120000)
        );

        var useCase = new UpdateNumberOfTickerForSaleUseCase();

        Mockito.when(repository.getEventsBy(saleId.value())).thenReturn(eventStored(saleId,date,numberTickets));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(saleId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (NumberOfTicketsForSaleUpdated)events.get(0);

        assertEquals(120000, event.getNumberOfTicketsForSale().value());
        Assertions.assertEquals(1, events.size());

    }

    private List<DomainEvent> eventStored(SaleIdentity saleId, Date date, NumberOfTicketsForSale numberTickets) {
        return List.of(
                new SaleCreated(
                        saleId,
                        date,
                        numberTickets
                )
        );
    }

}