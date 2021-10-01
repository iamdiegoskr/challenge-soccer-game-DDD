package com.sofka.challenge.soccergameddd.usecase.sale;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.soccergameddd.domain.sale.commands.AddCustomer;
import com.sofka.challenge.soccergameddd.domain.sale.events.CustomerAdded;
import com.sofka.challenge.soccergameddd.domain.sale.events.SaleCreated;
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
class AssignCustomerUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Validar la asignacion de un cliente a una venta")
    void AssignCustomer(){

        var saleIdentity = SaleIdentity.of("xxx");
        var saleDate = new Date("2020-10-02");
        var numTickets = new NumberOfTicketsForSale(50000);

        var customerId =  CustomerIdentity.of("yyy");
        var name = new Name("Juan Diego");
        var dateBirth = new DateOfBirth(18,9,1997);
        var email = new Email("juankeloke@gmail.com");
        var telephone = new Telephone("3107885498");
        var address = new Address("Carrera 80");

        var command = new AddCustomer(
                saleIdentity,
                customerId,
                name,
                dateBirth,
                email,
                telephone,
                address
        );

        var useCase = new AssignCustomerUseCase();

        Mockito.when(repository.getEventsBy(saleIdentity.value())).thenReturn(eventStored(saleIdentity,
                saleDate,numTickets));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(saleIdentity.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (CustomerAdded) events.get(0);

        Assertions.assertEquals("xxx", event.aggregateRootId());
        Assertions.assertEquals("Juan Diego", event.getName().value());
        Assertions.assertEquals("18-09-1997", event.getDateOfBirth().value());
        Assertions.assertEquals("juankeloke@gmail.com", event.getEmail().value());
        Assertions.assertEquals("3107885498", event.getTelephone().value());
        Assertions.assertEquals("Carrera 80", event.getAddress().value());
        Mockito.verify(repository).getEventsBy(saleIdentity.value());

    }

    private List<DomainEvent> eventStored(SaleIdentity saleId, Date date, NumberOfTicketsForSale numberTickets) {

        return List.of(
                new SaleCreated(saleId,date,numberTickets)
        );
    }

}