package com.foxminded.fastestRacers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.sound.sampled.Line;

public class FastestRacersGenerator {
    public String getRacersList() {
        File startFile = new File(getClass().getClassLoader().getResource("resources/start.log").getFile());
        File endFile = new File(getClass().getClassLoader().getResource("resources/end.log").getFile());
        File abrFile = new File(getClass().getClassLoader().getResource("resources/abbreviations.txt").getFile());

        Stream<String> streamFromStartFile;
        Stream<String> streamFromEndFile;
        Stream<String> streamFromAbrFile;

        try {
            streamFromStartFile = Files.lines(Paths.get(startFile.getAbsolutePath()));
            streamFromEndFile = Files.lines(Paths.get(endFile.getAbsolutePath()));
            streamFromAbrFile = Files.lines(Paths.get(abrFile.getAbsolutePath()));

            streamFromAbrFile.forEach(line -> createRacers(line.split("_")));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    private Racer createRacers(String[] arr) {
        Racer racer = new Racer();
        racer.setAbbreviation(arr[0]);
        racer.setName(arr[1]);
        racer.setCommandName(arr[2]);

        return racer;
    }

}
