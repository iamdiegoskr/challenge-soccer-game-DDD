package com.sofka.challenge.soccergameddd.usecase.sale;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.challenge.soccergameddd.domain.sale.commands.ChangeNameCustomer;
import com.sofka.challenge.soccergameddd.domain.sale.events.*;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChangeNameCustomerUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Metodo para validar el cambio de nombre de un cliente")
    void changeNameCustomer(){

        var saleId = "xxx";
        var customerId = "yyy";

        var command = new ChangeNameCustomer(
                SaleIdentity.of(saleId),
                CustomerIdentity.of(customerId),
                new Name("Pedrito")
        );

        var useCase = new ChangeNameCustomerUseCase();

        Mockito.when(repository.getEventsBy(saleId)).thenReturn(eventStored());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(saleId)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (NameUpdated)events.get(0);

        assertEquals("Pedrito", event.getName().value());
        Assertions.assertEquals(1, events.size());

    }

    private List<DomainEvent> eventStored() {

        var eventSaleCreated = new SaleCreated(
                SaleIdentity.of("xxx"),
                new Date("2020-10-02"),
                new NumberOfTicketsForSale(100000)
        );

        var eventCustomerCreated = new CustomerAdded(
                CustomerIdentity.of("yyy"),
                new Name("Diego"),
                new DateOfBirth(18,9,1997),
                new Email("juankeloke@gmail.com"),
                new Telephone("3107223477"),
                new Address("Carrera 22")
        );

        List<DomainEvent> listEventsDomain = new ArrayList<>();
        listEventsDomain.add(eventSaleCreated);
        listEventsDomain.add(eventCustomerCreated);

        return listEventsDomain;
    }


}