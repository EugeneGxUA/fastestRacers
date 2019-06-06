package com.foxminded.formula_one.reports.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hamcrest.core.IsInstanceOf;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import com.foxminded.formula_one.reports.utils.FileReader;

class FileReaderTest {
    
    private FileReader reader = new FileReader();
    
    @Test
    void shouldReturnListFromFile() throws IOException {
        List<String> expected = reader.readLines("start.log");
        assertThat(expected, IsInstanceOf.instanceOf(List.class));
    }
    
    @Test
    void shouldReturnLengthOfReadedLines() throws IOException {
        int expected = 19;
        List<String> actual = reader.readLines("start.log");
        assertEquals(expected, actual.size());
    }
    
    @Test
    void shouldReturnNonEmptyLines() throws IOException {
        Random random = new Random();
        List<String> list = reader.readLines("start.log");
        
        String actual = list.get(random.nextInt(18));
        assertTrue(StringUtils.isNotBlank(actual));
    }
    
    @Test
    void shouldReturnNonEmptyLine() throws IOException {
        List<String> list = reader.readLines("start.log");
        
        String actual = list.get(0);
        String expected = "SVF2018-05-24_12:02:58.917";
        assertEquals(actual.length(), expected.length());
    }
    
    @Test
    void shouldReturnFNFEWhenFileIsNotExsist() {
        assertThrows(FileNotFoundException.class, () -> {
            reader.readLines("hello");
        });

    }
    
    @Test
    void shouldReturnIllArgExcWhenFileNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            reader.readLines("");
        });
    }
    
    @Test
    void shouldReturnEmptyList() throws IOException {
        List<String> expected = new ArrayList<>();
        
        List<String> actual = reader.readLines("emptyTestFile");
        assertEquals(expected, actual);
    }
}
