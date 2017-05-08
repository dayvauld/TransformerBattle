package com.aequilibrium;

import com.aequilibrium.Exception.OptimusPrimePredakingException;
import com.aequilibrium.Transformer.Autobot;
import com.aequilibrium.Transformer.Decepticon;
import com.aequilibrium.Transformer.Transformer;

import java.util.*;


public class Battle {
    private List<Transformer> autobots = new ArrayList<>();
    private List<Transformer> decepticons = new ArrayList<>();
    private int numOfBattles = 0;
    private int numOfAutobotWins = 0;
    private int numOfDecepticonWins = 0;

    public void battleForEarth(List<Transformer> autobots, List<Transformer> decepticons) {
        this.autobots = autobots;
        this.decepticons = decepticons;
        battleTeams();
    }

    public int getNumOfBattles() {
        return this.numOfBattles;
    }

    public int getNumOfAutobotWins() {
        return this.numOfAutobotWins;
    }

    public int getNumOfDecepticonWins() {
        return this.numOfDecepticonWins;
    }

    private void battleTeams() {
        //Sort teams
        Collections.sort(autobots);
        Collections.sort(decepticons);

        //Fight individual bots
        Iterator<Transformer> autobotIterator = autobots.iterator();
        Iterator<Transformer> decepticonIterator = decepticons.iterator();

        while (autobotIterator.hasNext() && decepticonIterator.hasNext()) {
            numOfBattles++;
            fightTransformers((Autobot) autobotIterator.next(), (Decepticon) decepticonIterator.next());
        }
    }

    private void fightTransformers(Autobot a, Decepticon d) {
        if(a.getName().contains("OptimusPrime") && d.getName().contains("Predaking")) {
            throw new OptimusPrimePredakingException();
        } else if (a.getName().contains("OptimusPrime")) {
            //Optimus Prime wins
            d.killTransformer();
            numOfAutobotWins++;
        } else if(d.getName().contains("Predaking")) {
            //Predaking wins
            a.killTransformer();
            numOfDecepticonWins++;
        } else {
            if((a.getCourage().getValue() - d.getCourage().getValue()) >= 4 &&
                    (a.getStrength().getValue() - d.getStrength().getValue()) >= 3) {
                //Decepticon has run away
                d.killTransformer();
                numOfAutobotWins++;
            } else if((d.getCourage().getValue() - a.getCourage().getValue()) >= 4 &&
                    (d.getStrength().getValue() - a.getStrength().getValue()) >= 3) {
                //Autobot has run away
                a.killTransformer();
                numOfDecepticonWins++;
            } else if((a.getSkill().getValue() - d.getSkill().getValue()) > 3) {
                //Autobot is so skilled it beats decepticon
                d.killTransformer();
                numOfAutobotWins++;
            } else if((d.getSkill().getValue() - a.getSkill().getValue()) > 3) {
                //Decepticon is so skilled it beats autobot
                a.killTransformer();
                numOfDecepticonWins++;
            } else if(a.compareTo(d) == 0) {
                //Tie, both are destroyed
                a.killTransformer();
                d.killTransformer();
            } else if(a.compareTo(d) > 0) {
                //Autobot wins by rank
                d.killTransformer();
                numOfAutobotWins++;
            } else {
                //Decepticon wins by rank
                a.killTransformer();
                numOfDecepticonWins++;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if(numOfBattles > 1)
            stringBuilder.append(numOfBattles + " Battles\n");
        else
            stringBuilder.append(numOfBattles + " Battle\n");

        if(numOfAutobotWins > numOfDecepticonWins) {

            stringBuilder.append("Winning Team(Autobots): ");
            for(Transformer a : autobots)
                if(a.isAlive())
                    stringBuilder.append(a.getName() + ", ");
            stringBuilder.deleteCharAt(stringBuilder.length()-2); //trim trailing ','
            stringBuilder.append("\nSurvivors from the losing team: ");
            for(Transformer d : decepticons)
                if(d.isAlive())
                    stringBuilder.append(d.getName() + ", ");
            stringBuilder.deleteCharAt(stringBuilder.length()-2);
        }
        else {
            stringBuilder.append("Winning Team(Decepticons): ");
            for(Transformer d : decepticons)
                if(d.isAlive())
                    stringBuilder.append(d.getName() + ", ");
            stringBuilder.deleteCharAt(stringBuilder.length()-2);
            stringBuilder.append("\nSurvivors from the losing team: ");
            for(Transformer a : autobots)
                if(a.isAlive())
                    stringBuilder.append(a.getName() + ", ");
            stringBuilder.deleteCharAt(stringBuilder.length()-2);
        }

        return stringBuilder.toString();
    }


    public String getAutobotSurvivors() {
        StringBuilder survivors = new StringBuilder();
        for(Transformer a : autobots)
            if(a.isAlive())
                survivors.append(a.getName() + ", ");
        return survivors.toString();
    }

    public String getDecepticonSurvivors() {
        StringBuilder survivors = new StringBuilder();
        for(Transformer a : decepticons)
            if(a.isAlive())
                survivors.append(a.getName() + ", ");
        return survivors.toString();
    }

}
