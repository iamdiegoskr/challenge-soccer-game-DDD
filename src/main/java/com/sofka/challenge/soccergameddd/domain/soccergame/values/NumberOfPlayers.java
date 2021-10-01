package com.sofka.challenge.soccergameddd.domain.soccergame.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NumberOfPlayers implements ValueObject<Integer> {

    private final Integer value;

    public NumberOfPlayers(Integer value) {
        this.value = Objects.requireNonNull(value);

        if(this.value<11){
            throw new IllegalArgumentException("Deben haber minimo 11 Jugadores");
        }

        if(this.value>50){
            throw new IllegalArgumentException("La plantilla no puede superar los 50 jugadores");
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
        NumberOfPlayers that = (NumberOfPlayers) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
