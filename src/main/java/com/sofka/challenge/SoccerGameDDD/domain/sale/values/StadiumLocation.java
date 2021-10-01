package com.sofka.challenge.SoccerGameDDD.domain.sale.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class StadiumLocation implements ValueObject<String> {

    private final String value;

    public StadiumLocation(String value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("La localidad no puede estar vacia");
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
        StadiumLocation that = (StadiumLocation) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
