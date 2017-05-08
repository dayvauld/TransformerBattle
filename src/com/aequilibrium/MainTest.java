package com.aequilibrium;


import com.aequilibrium.Transformer.Autobot;
import com.aequilibrium.Transformer.Decepticon;
import com.aequilibrium.Transformer.Transformer;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class MainTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.Test
    public void testBattleForEarthTie() throws Exception {
        List<Transformer> autobots = new ArrayList<>();
        List<Transformer> decepticons = new ArrayList<>();

        decepticons.add(new Decepticon("TestRobot",'D',1,2,3,4,5,6,7,8));
        decepticons.add(new Decepticon("TestRobot",'D',1,2,3,4,5,6,7,8));
        decepticons.add(new Decepticon("TestRobot",'D',1,2,3,4,5,6,7,8));
        autobots.add(new Autobot("TestRobot",'A',1,2,3,4,5,6,7,8));
        autobots.add(new Autobot("TestRobot",'A',1,2,3,4,5,6,7,8));
        autobots.add(new Autobot("TestRobot",'A',1,2,3,4,5,6,7,8));

        Battle battleForEarth = new Battle();
        battleForEarth.battleForEarth(autobots,decepticons);

        Assert.assertEquals(3,battleForEarth.getNumOfBattles());
        Assert.assertEquals(0,battleForEarth.getNumOfAutobotWins());
        Assert.assertEquals(0,battleForEarth.getNumOfDecepticonWins());
    }

    @org.junit.Test
    public void testPredaking() throws Exception {
        List<Transformer> autobots = new ArrayList<>();
        List<Transformer> decepticons = new ArrayList<>();

        autobots.add(new Autobot("OtherGuy",'A',1,1,3,4,5,6,7,8));
        decepticons.add(new Decepticon("Predaking",'D',1,2,3,4,5,6,7,8));

        Battle battleForEarth = new Battle();
        battleForEarth.battleForEarth(autobots,decepticons);

        Assert.assertEquals(1,battleForEarth.getNumOfBattles());
        Assert.assertEquals(true,battleForEarth.getAutobotSurvivors().isEmpty());
        Assert.assertEquals(true,battleForEarth.getDecepticonSurvivors().contains("Predaking"));
    }

    @org.junit.Test
    public void testOptimusPrime() throws Exception {
        List<Transformer> autobots = new ArrayList<>();
        List<Transformer> decepticons = new ArrayList<>();

        autobots.add(new Autobot("OptimusPrime",'A',1,1,3,4,5,6,7,8));
        decepticons.add(new Decepticon("PoorRobot",'D',1,2,3,4,5,6,7,8));

        Battle battleForEarth = new Battle();
        battleForEarth.battleForEarth(autobots,decepticons);

        Assert.assertEquals(1,battleForEarth.getNumOfBattles());
        Assert.assertEquals(true,battleForEarth.getAutobotSurvivors().contains("OptimusPrime"));
    }


    @org.junit.Test
    public void testRunAwayWin() throws Exception {
        List<Transformer> autobots = new ArrayList<>();
        List<Transformer> decepticons = new ArrayList<>();

        autobots.add(new Autobot("ToughGuy",'A',4,1,3,4,5,6,7,8));
        decepticons.add(new Decepticon("Runner",'D',1,2,3,4,5,2,7,8));

        Battle battleForEarth = new Battle();
        battleForEarth.battleForEarth(autobots,decepticons);

        Assert.assertEquals(1,battleForEarth.getNumOfBattles());
        Assert.assertEquals(true,battleForEarth.getAutobotSurvivors().contains("ToughGuy"));
    }


    @org.junit.Test
    public void testSkillWin() throws Exception {
        List<Transformer> autobots = new ArrayList<>();
        List<Transformer> decepticons = new ArrayList<>();

        autobots.add(new Autobot("NotSoSkilled",'A',1,1,3,4,5,6,7,1));
        decepticons.add(new Decepticon("VerySkilled",'D',1,2,3,4,5,6,7,8));

        Battle battleForEarth = new Battle();
        battleForEarth.battleForEarth(autobots,decepticons);

        Assert.assertEquals(1,battleForEarth.getNumOfBattles());
        Assert.assertEquals(true,battleForEarth.getDecepticonSurvivors().contains("VerySkilled"));
    }
}