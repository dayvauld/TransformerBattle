package com.aequilibrium;

import com.aequilibrium.Transformer.Autobot;
import com.aequilibrium.Transformer.Decepticon;
import com.aequilibrium.Transformer.Transformer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Transformer> autobots = new ArrayList<>();
    private static final List<Transformer> decepticons = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        //Read in transformers from textfile
        Scanner sc = new Scanner(new FileReader(args[0]));
        String transformer;
        while(sc.hasNextLine()) {
            transformer = sc.nextLine();
            transformer = transformer.replaceAll("\\s","");
            List<String> inputValues = Arrays.asList(transformer.split(","));
            if (inputValues.get(1).contains("A")) {
                autobots.add(new Autobot(inputValues.get(0),
                        'A',
                        Integer.parseInt(inputValues.get(2)),
                        Integer.parseInt(inputValues.get(3)),
                        Integer.parseInt(inputValues.get(4)),
                        Integer.parseInt(inputValues.get(5)),
                        Integer.parseInt(inputValues.get(6)),
                        Integer.parseInt(inputValues.get(7)),
                        Integer.parseInt(inputValues.get(8)),
                        Integer.parseInt(inputValues.get(9))));
            } else if (inputValues.get(1).contains("D")) {
                decepticons.add(new Decepticon(inputValues.get(0),
                        'D',
                        Integer.parseInt(inputValues.get(2)),
                        Integer.parseInt(inputValues.get(3)),
                        Integer.parseInt(inputValues.get(4)),
                        Integer.parseInt(inputValues.get(5)),
                        Integer.parseInt(inputValues.get(6)),
                        Integer.parseInt(inputValues.get(7)),
                        Integer.parseInt(inputValues.get(8)),
                        Integer.parseInt(inputValues.get(9))));
            }
        }

        //Battle transformers
        Battle battleForEarth = new Battle();
        battleForEarth.battleForEarth(autobots,decepticons);
        System.out.println(battleForEarth.toString());
    }
}
