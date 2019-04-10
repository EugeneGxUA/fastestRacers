package com.foxminded.fastestRacers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FastestRacersMain {
    
    public static void main(String[] args) {
        
        File startLogFile = new File(FastestRacersMain.class.getResource("/resources/start.log").getFile());
        File endLogFile = new File(FastestRacersMain.class.getResource("/resources/end.log").getFile());
        File abbreviationsFile = new File(FastestRacersMain.class.getResource("/resources/abbreviations.txt").getFile());
        
        try {
            Stream<String> startLogStream = Files.lines(Paths.get(startLogFile.getAbsolutePath()));
            Stream<String> endLogStream = Files.lines(Paths.get(endLogFile.getAbsolutePath()));
            Stream<String> abbreviationsFileStream = Files.lines(Paths.get(abbreviationsFile.getAbsolutePath()));
            
            FastestRacersGenerator fg = new FastestRacersGenerator();
            System.out.println(fg.generateRacersBoard(startLogStream, endLogStream, abbreviationsFileStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
