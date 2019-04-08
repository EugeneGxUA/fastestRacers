package com.foxminded.fastestRacers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FastestRacersGenerator {
    public String getRacersList()  {
        
        ClassLoader classLoader = getClass().getClassLoader();
        Stream<String> streamFromFiles;
        
        
        try {
            streamFromFiles = Files.lines(Paths.get(this.getClass().getClassLoader().getResource("start.log").getPath()));
            
            streamFromFiles.forEach(line -> System.out.println(line));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
        
//        InputStream in = getClass().getClassLoader().getResourceAsStream("start.log"); 
//        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        
//        String line;
//        while ((line = reader.readLine()) != null) {
//            System.out.println(line);
//        }
        
        
        return null;
    }
}
