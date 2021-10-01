package com.sofka.challenge.soccergameddd.domain.sale.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NumberOfTicketsForSale implements ValueObject<Integer> {

    private final Integer value;

    public NumberOfTicketsForSale(Integer value) {
        this.value = Objects.requireNonNull(value);

        if(this.value<1){
            throw new IllegalArgumentException("El numero de boletas debe ser mayor a 0");
        }

        if(this.value.toString().isBlank()){
            throw new IllegalArgumentException("El numero de boletas no puede estar vacio");
        }

    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberOfTicketsForSale that = (NumberOfTicketsForSale) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
