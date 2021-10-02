package com.sofka.challenge.soccergameddd.usecase.sale.usecaseevent;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.challenge.soccergameddd.domain.sale.events.NumberOfTicketsForSaleUpdated;
import com.sofka.challenge.soccergameddd.domain.sale.events.NumberOfTicketsNotified;
import com.sofka.challenge.soccergameddd.domain.sale.values.NumberOfTicketsForSale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NotifyNumberOfTicketsUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void notifyNumberTickets(){

        var event = new NumberOfTicketsForSaleUpdated(
                new NumberOfTicketsForSale(100000)
        );

        event.setAggregateRootId("xxx");

        var useCase = new NotifyNumberOfTicketsUseCase();

        Mockito.when(repository.getEventsBy("xxx")).thenReturn(List.of(event));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx")
                .syncExecutor(useCase,new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var notification = (NumberOfTicketsNotified) events.get(0);

        Assertions.assertEquals("120000", notification.getNumberOfTickesMessage());
        Mockito.verify(repository).getEventsBy("xxx");

    }

}