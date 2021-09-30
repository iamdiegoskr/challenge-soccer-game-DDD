package com.sofka.challenge.SoccerGameDDD.domain.soccergame.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ArbitrationCharge implements ValueObject<String> {

    private final String value;

    public ArbitrationCharge(String value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("EL cargo arbitral no puede estar vacio");
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
        ArbitrationCharge that = (ArbitrationCharge) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
