package com.sofka.challenge.SoccerGameDDD.domain.sale;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofka.challenge.SoccerGameDDD.domain.sale.entities.Customer;
import com.sofka.challenge.SoccerGameDDD.domain.sale.entities.Invoice;
import com.sofka.challenge.SoccerGameDDD.domain.sale.entities.Ticket;
import com.sofka.challenge.SoccerGameDDD.domain.sale.events.*;
import com.sofka.challenge.SoccerGameDDD.domain.sale.values.*;
import com.sofka.challenge.SoccerGameDDD.domain.shared.values.Date;
import com.sofka.challenge.SoccerGameDDD.domain.shared.values.Name;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.values.SoccerGameIdentity;

import java.util.Objects;


public class Sale extends AggregateEvent<SaleIdentity> {

    protected SoccerGameIdentity soccerGameId;
    protected Customer customer;
    protected Invoice invoice;
    protected Ticket ticket;
    protected Date date;
    protected NumberOfTicketsForSale numberOfTicketsForSale;

    public Sale(SaleIdentity saleIdentity, Date date, NumberOfTicketsForSale numberOfTicketsForSale) {
        super(saleIdentity);
        appendChange(new SaleCreated(saleIdentity, date, numberOfTicketsForSale)).apply();
    }


    public void associateSoccerGame(SoccerGameIdentity soccerGameIdentity){
        Objects.requireNonNull(soccerGameIdentity);
        appendChange(new AssociatedGame(soccerGameIdentity)).apply();
    }

    public void addCustomer(CustomerIdentity customerId, Name name,
                            DateOfBirth dateOfBirth, Email email, Telephone telephone, Address address){
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(dateOfBirth);
        Objects.requireNonNull(email);
        Objects.requireNonNull(telephone);
        Objects.requireNonNull(address);
        appendChange(new CustomerAdded(customerId,name,dateOfBirth,email,telephone, address)).apply();
    }

    public void addInvoice(InvoiceIdentity invoiceIdentity, Price price, Date date){
        Objects.requireNonNull(invoiceIdentity);
        Objects.requireNonNull(price);
        Objects.requireNonNull(date);
        appendChange(new InvoiceAdded(invoiceIdentity,price,date)).apply();
    }

     public void addTicket(TicketIdentity ticketId,PaymentType paymentType, StadiumLocation stadiumLocation, Price price){
        Objects.requireNonNull(ticketId);
        Objects.requireNonNull(paymentType);
        Objects.requireNonNull(stadiumLocation);
        Objects.requireNonNull(price);
        appendChange(new TicketAdded(ticketId,paymentType,stadiumLocation,price)).apply();
     }


     public void updateNumberOfTicketsForSale(NumberOfTicketsForSale numberOfTicketsForSale){
        Objects.requireNonNull(numberOfTicketsForSale);
        appendChange(new NumberOfTicketsForSaleUpdated(numberOfTicketsForSale)).apply();
     }


     public void updateNameCustomer(Name name){
        Objects.requireNonNull(name);
        appendChange(new NameUpdated(name)).apply();
     }


}
