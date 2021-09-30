package com.sofka.challenge.SoccerGameDDD.domain.soccergame;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.entities.Referee;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.entities.Stadium;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.entities.Team;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.events.AddedReferee;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.events.AddedStadium;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.events.AddedTeam;
import com.sofka.challenge.SoccerGameDDD.domain.soccergame.events.SoccerGameCreated;

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
                    new Referee(event.getRefereeId(),event.getName())
            );

        });

        



    }
}
