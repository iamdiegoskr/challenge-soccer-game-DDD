package com.sofka.challenge.soccergameddd.domain.soccergame;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.challenge.soccergameddd.domain.soccergame.entities.Referee;
import com.sofka.challenge.soccergameddd.domain.soccergame.entities.Schedule;
import com.sofka.challenge.soccergameddd.domain.soccergame.entities.Stadium;
import com.sofka.challenge.soccergameddd.domain.soccergame.entities.Team;
import com.sofka.challenge.soccergameddd.domain.soccergame.events.*;

import java.util.HashSet;

public class SoccerGameChange extends EventChange {

    public SoccerGameChange(SoccerGame soccerGame) {

        apply((SoccerGameCreated event)->{
            soccerGame.tournament = event.getTournament();
            soccerGame.teams = new HashSet<>();
            soccerGame.referees = new HashSet<>();
        });

        apply((AddedStadium event)->{
            soccerGame.stadium = new Stadium(event.getStadiumIdentity(),
                    event.getName(),event.getCapacity(),event.getLocation());
        });

        apply((AddedTeam event)->{

            var numberTeams = soccerGame.teams.size();

            if(numberTeams>2){
                throw new IllegalArgumentException("Un partido de futbol solo puede tener 2 equipos");
            }

            soccerGame.teams.add(
                    new Team(event.getTeamId(),event.getNameTeam(),event.getCity(),event.getNumberOfPlayers())
            );

        });

        apply((AddedReferee event)->{

            var numberReferees = soccerGame.referees.size();

            if(numberReferees>4){
                throw new IllegalArgumentException("EL maximo de arbitros por partidos es 4");
            }

            soccerGame.referees.add(
                    new Referee(event.getRefereeId(),event.getName(), event.getArbitrationCharge())
            );

        });


        apply((ReportGameGenerated event)-> soccerGame.referees.forEach(referee -> {
            if(referee.getArbitrationCharge().equals("principal")){
                referee.generateReportGame(event.getReportGame());
            }
        }));

        apply((AddedSchedule event)->{
            soccerGame.schedule = new Schedule(event.getScheduleId(),event.getHour(),event.getDate());
        });

        apply((UpdatedGoalsGame event)->{
            soccerGame.numberOfGoals = event.getNumberOfGoals();
        });

    }
}
