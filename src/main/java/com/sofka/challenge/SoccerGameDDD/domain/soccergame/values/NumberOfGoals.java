package com.sofka.challenge.SoccerGameDDD.domain.soccergame.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NumberOfGoals implements ValueObject<Integer> {

    private final Integer value;

    public NumberOfGoals(Integer value) {
        this.value = Objects.requireNonNull(value);

        if(this.value<0){
            throw new IllegalArgumentException("No puede ingresar un numero negativo");
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
        NumberOfGoals that = (NumberOfGoals) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
