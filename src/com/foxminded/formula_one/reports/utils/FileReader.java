package com.foxminded.formula_one.reports.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {
    public List<String> readLines(String fileName) throws IOException {
        
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException(ExceptionConstants.EMPTY_FILE_NAME);
        }
        try {
            List<String> lines = Files.lines(Paths.get(this.getClass().getResource("/" + fileName).getPath())).collect(Collectors.toList());
            if (lines.isEmpty()) {
                throw new IllegalArgumentException(ExceptionConstants.EMPTY_FILE);
            }
            
            return lines;
        } catch (NullPointerException e) {
            throw new FileNotFoundException(ExceptionConstants.NO_FILE);
        }
    }
}
