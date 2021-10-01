package com.sofka.challenge.soccergameddd.domain.sale.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DateOfBirth implements ValueObject<String> {

    private final LocalDate date;
    private final String formatDate;

    public DateOfBirth(int day, int month, int year) {
        try {
            date = LocalDate.of(year, month, day);
            if(date.isAfter(LocalDate.now())){
                throw new IllegalArgumentException("La fecha de cumpleaños no es valido");
            }
        } catch (DateTimeException e){
            throw new IllegalArgumentException(e.getMessage());
        }
        formatDate = generateFormat();
    }

    private String generateFormat(){
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public String value() {
        return formatDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateOfBirth that = (DateOfBirth) o;
        return Objects.equals(date, that.date) && Objects.equals(formatDate, that.formatDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, formatDate);
    }
}
