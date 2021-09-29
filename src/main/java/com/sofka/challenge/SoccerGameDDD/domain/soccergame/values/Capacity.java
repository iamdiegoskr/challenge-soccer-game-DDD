package com.sofka.challenge.SoccerGameDDD.domain.soccergame.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Capacity implements ValueObject<Integer> {

    private final Integer value;

    public Capacity(Integer value) {
        this.value = Objects.requireNonNull(value);

        if(this.value<0 || this.value>200000){
            throw new IllegalArgumentException("La capacidad no es valida");
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
        Capacity capacity = (Capacity) o;
        return Objects.equals(value, capacity.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
