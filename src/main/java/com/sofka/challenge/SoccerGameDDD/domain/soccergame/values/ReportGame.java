package com.sofka.challenge.SoccerGameDDD.domain.soccergame.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ReportGame implements ValueObject<String> {

    private final String value;

    public ReportGame(String value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("El informe no puede estar vacio");
        }

        if(this.value.length()<50){
            throw new IllegalArgumentException("El informe es demasido corto");
        }

        if(this.value.length()>1000){
            throw new IllegalArgumentException("El informe es demasido largo");
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
        ReportGame that = (ReportGame) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
