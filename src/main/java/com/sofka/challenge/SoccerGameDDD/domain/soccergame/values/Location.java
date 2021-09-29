package com.sofka.challenge.SoccerGameDDD.domain.soccergame.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Location implements ValueObject<Location.Props> {

    private final String street;
    private final String city;
    private final String country;

    public Location(String street, String city, String country) {
        this.street = Objects.requireNonNull(street);
        this.city = Objects.requireNonNull(city);
        this.country = Objects.requireNonNull(country);

        if(this.street.isBlank()){
            throw new IllegalArgumentException("La direccion no puede estar vacia");
        }

        if(this.city.isBlank()){
            throw new IllegalArgumentException("La ciudad no puede estar vacia");
        }

        if(this.country.isBlank()){
            throw new IllegalArgumentException("El pais no puede estar vacio");
        }

    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String street() {
                return street;
            }

            @Override
            public String city() {
                return city;
            }

            @Override
            public String country() {
                return country;
            }
        };
    }

    public interface Props{
        String street();
        String city();
        String country();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(street, location.street) &&
                Objects.equals(city, location.city) && Objects.equals(country, location.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, country);
    }
}
