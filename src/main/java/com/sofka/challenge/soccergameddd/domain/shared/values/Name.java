package com.sofka.challenge.soccergameddd.domain.shared.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Name implements ValueObject<String> {

    private final String value;

    public Name(String value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }

        if(this.value.length()<5){
            throw new IllegalArgumentException("EL nombre debe contener mas de 5 caracteres");
        }

        if(this.value.length()>100){
            throw new IllegalArgumentException("El nombre no puede superar los 100 caracteres");
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
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
