package com.sofka.challenge.soccergameddd.domain.soccergame.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class City implements ValueObject<String> {

    private final String value;

    public City(String value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("La ciudad del equipo no puede estar vacia");
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
        City city = (City) o;
        return Objects.equals(value, city.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
