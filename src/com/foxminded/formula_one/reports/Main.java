package com.foxminded.formula_one.reports;

import java.io.FileNotFoundException;

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        String startLogFileName = "start.log";
        String endLogFileName = "end.log";
        String abbrFileName = "abbreviations.txt";
            
        RacersBoardGenerator fg = new RacersBoardGenerator();
        System.out.println(fg.buildStageBoard(startLogFileName, endLogFileName, abbrFileName));
    }
}
