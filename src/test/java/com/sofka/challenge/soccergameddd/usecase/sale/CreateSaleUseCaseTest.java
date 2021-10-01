package com.sofka.challenge.soccergameddd.usecase.sale;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.challenge.soccergameddd.domain.sale.commands.CreateSale;
import com.sofka.challenge.soccergameddd.domain.sale.events.SaleCreated;
import com.sofka.challenge.soccergameddd.domain.sale.values.NumberOfTicketsForSale;
import com.sofka.challenge.soccergameddd.domain.sale.values.SaleIdentity;
import com.sofka.challenge.soccergameddd.domain.shared.values.Date;
import com.sofka.challenge.soccergameddd.domain.soccergame.commands.CreateSoccerGame;
import com.sofka.challenge.soccergameddd.domain.soccergame.events.SoccerGameCreated;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.SoccerGameIdentity;
import com.sofka.challenge.soccergameddd.domain.soccergame.values.Tournament;
import com.sofka.challenge.soccergameddd.usecase.soccergame.CreateSoccerGameUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CreateSaleUseCaseTest {

    @Test
    @DisplayName("Validar la cracion de una venta")
    void createSale(){

        var command = new CreateSale(
                SaleIdentity.of("xxx"),
                new Date("2021-10-02"),
                new NumberOfTicketsForSale(50000)
        );

        var useCase = new CreateSaleUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (SaleCreated) events.get(0);

        Assertions.assertTrue(Objects.nonNull(event.getSaleIdentity().value()));
        Assertions.assertEquals("2021-10-02", event.getDate().value());
        Assertions.assertEquals(50000, event.getNumberOfTicketsForSale().value());

    }

}