package com.sofka.challenge.soccergameddd.domain.sale;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.challenge.soccergameddd.domain.sale.entities.Customer;
import com.sofka.challenge.soccergameddd.domain.sale.entities.Invoice;
import com.sofka.challenge.soccergameddd.domain.sale.entities.Ticket;
import com.sofka.challenge.soccergameddd.domain.sale.events.*;

public class SaleChange extends EventChange {

    public SaleChange(Sale sale) {

        apply((SaleCreated event)->{
            sale.date = event.getDate();
            sale.numberOfTicketsForSale = event.getNumberOfTicketsForSale();
        });

        apply((AssociatedGame event)->{
            sale.soccerGameId = event.getSoccerGameIdentity();
        });

        apply((CustomerAdded event)->{
            sale.customer = new Customer(event.getCustomerId(),event.getName(),event.getDateOfBirth(),
                    event.getEmail(),event.getTelephone(),event.getAddress());
        });

        apply((InvoiceAdded event)->{
            sale.invoice = new Invoice(event.getInvoiceIdentity(),event.getPrice(),event.getDate());
        });

        apply((TicketAdded event)->{
            sale.ticket = new Ticket(event.getTicketId(),event.getPaymentType(),event.getStadiumLocation(),
                    event.getPrice());
        });

        apply((NumberOfTicketsForSaleUpdated event)->{
            sale.numberOfTicketsForSale = event.getNumberOfTicketsForSale();
        });

        apply((NameUpdated event)->{
            sale.customer.updateNameCustomer(event.getName());
        });

        apply((PriceInvoiceUpdated event)->{
            sale.invoice.updatePrice(event.getPrice());
        });

        apply((StadiumLocationUpdated event)->{
            sale.ticket.updateStadiumLocation(event.getLocation());
        });


    }
}
