package com.sofka.challenge.SoccerGameDDD.domain.soccergame.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NameStadium implements ValueObject<String> {

    private final String value;

    public NameStadium(String value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("El nombre del estadio no puede estar vacio");
        }

        if(this.value.length()<5){
            throw new IllegalArgumentException("El nombre del estadio debe contener mas de 5 caracteres");
        }

        if(this.value.length()>100){
            throw new IllegalArgumentException("El nombre del estadio no puede superar los 100 caracteres");
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
        NameStadium that = (NameStadium) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
