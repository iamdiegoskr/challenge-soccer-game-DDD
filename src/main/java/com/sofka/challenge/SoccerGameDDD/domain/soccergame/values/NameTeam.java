package com.sofka.challenge.SoccerGameDDD.domain.soccergame.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NameTeam implements ValueObject<String> {

    private final String value;

    public NameTeam(String name) {
        this.value = Objects.requireNonNull(name);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("El nombre del equipo no puede estar vacio");
        }

        if(this.value.length()<5){
            throw new IllegalArgumentException("El nombre del equipo es demasido corto");
        }

        if(this.value.length()>100){
            throw new IllegalArgumentException("El nombre del equipo es demasido largo");
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
        NameTeam nameTeam = (NameTeam) o;
        return Objects.equals(value, nameTeam.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
