package com.sofka.challenge.soccergameddd.domain.sale.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telephone implements ValueObject<String> {

    private final String value;

    public Telephone(String value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("EL telefono no puede estar vacio");
        }

        if(this.value.length()!=10){
            throw new IllegalArgumentException("EL telefono debe contener 10 digitos");
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
        Telephone telephone = (Telephone) o;
        return Objects.equals(value, telephone.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}