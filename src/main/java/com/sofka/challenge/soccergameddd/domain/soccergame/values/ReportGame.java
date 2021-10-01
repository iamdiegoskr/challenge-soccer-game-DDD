package com.sofka.challenge.soccergameddd.domain.soccergame.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ReportGame implements ValueObject<ReportGame.Props> {

    private final Integer playersRedCard;
    private final Integer playersYellowCard;
    private final String analysis;
    private final String date;

    public ReportGame(Integer playersRedCard, Integer playersYellowCard, String analysis, String date) {
        this.playersRedCard = Objects.requireNonNull(playersRedCard);
        this.playersYellowCard = Objects.requireNonNull(playersYellowCard);
        this.analysis = Objects.requireNonNull(analysis);
        this.date = Objects.requireNonNull(date);

        if(this.playersRedCard<0 || this.playersYellowCard<0){
            throw new IllegalArgumentException("Ingrese un valor valido para las tarjetas");
        }

        if(this.analysis.isBlank()){
            throw new IllegalArgumentException("EL analisis del partido no puede estar vacio");
        }

        if(this.date.isBlank()){
            throw new IllegalArgumentException("La fecha del reporte no puede estar vacia");
        }

    }


    @Override
    public Props value() {
        return new Props() {
            @Override
            public Integer playersRedCard() {
                return playersRedCard;
            }

            @Override
            public Integer playersYellowCard() {
                return playersYellowCard;
            }

            @Override
            public String analysis() {
                return analysis;
            }

            @Override
            public String date() {
                return date;
            }
        };
    }

    public interface Props{
        Integer playersRedCard();
        Integer playersYellowCard();
        String analysis();
        String date();
    }


}
