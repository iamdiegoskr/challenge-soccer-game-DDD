package com.sofka.challenge.SoccerGameDDD.domain.sale.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PaymentType implements ValueObject<String> {

    private final String value;

    public PaymentType(String value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("El metodo de pago no puede estar vacio");
        }

    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentType that = (PaymentType) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
