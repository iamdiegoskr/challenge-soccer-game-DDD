package com.sofka.challenge.soccergameddd.domain.soccergame.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Hour implements ValueObject<String> {

    private static final String TIME12HOURS_PATTERN = "(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)";

    private final String value;

    public Hour(String value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("La hora no puede estar vacia");
        }

        if(!validate(this.value)){
            throw new IllegalArgumentException("La hora no es valida");
        }

    }

    public boolean validate(final String time) {
        Pattern pattern = Pattern.compile(TIME12HOURS_PATTERN);
        Matcher matcher = pattern.matcher(time);
        return matcher.matches();
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hour hour = (Hour) o;
        return Objects.equals(value, hour.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}


