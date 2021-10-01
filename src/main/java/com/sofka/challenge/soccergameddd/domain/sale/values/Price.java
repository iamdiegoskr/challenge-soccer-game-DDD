package com.sofka.challenge.soccergameddd.domain.sale.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Price implements ValueObject<Double> {

    private final Double value;

    public Price(Double value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.toString().isBlank()){
            throw new IllegalArgumentException("EL precio de la factura no puede estar vacio");
        }

        if(this.value<1){
            throw new IllegalArgumentException("EL precio de la factura no puede ser 0 o un valor negativo");
        }

    }


    @Override
    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(value, price.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
