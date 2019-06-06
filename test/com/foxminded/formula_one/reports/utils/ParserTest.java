package com.foxminded.formula_one.reports.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.hamcrest.core.IsInstanceOf;
import org.junit.jupiter.api.Test;

import com.foxminded.formula_one.reports.models.Racer;
import com.foxminded.formula_one.reports.utils.Parser;

class ParserTest {
    
    private Parser parser = new Parser();
   
    @Test
    void shouldReturnRacerFromString() {
        
        Racer actual = parser.createRacerFromString("SVF_Sebastian Vettel_FERRARI");
        String expectedAbbr = "SVF";
        String expectedFullName = "Sebastian Vettel";
        String expectedTeamName = "FERRARI";
        assertThat(actual, IsInstanceOf.instanceOf(Racer.class));
        
        assertEquals(actual.getAbbreviation(), expectedAbbr);
        assertEquals(actual.getName(), expectedFullName);
        assertEquals(actual.getTeamName(), expectedTeamName);
    }
    
    @Test
    void shouldReturnIllArgExceptionWhenArgumentIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            parser.createRacerFromString("");
        });
    }
    
    @Test
    void shouldReturnIllArgExceptionWhenArgumentIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            parser.createRacerFromString(null);
        });
    }
    
    @Test
    void shouldReturnIllArgExceptionWhenArgumentHaveWrongFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            parser.createRacerFromString("aa");
        });
    }
    
    @Test
    void shouldReturnLocalDateTime() {
        LocalDateTime actual = parser.parseTimeDateFromString("2018-05-24_12:04:03.332");
        assertThat(actual, IsInstanceOf.instanceOf(LocalDateTime.class));
    }
    
    @Test
    void shouldReturnIllArgExceptionWhenArgIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            parser.createRacerFromString("");
        });
    }
    
    @Test
    void shouldReturnIllArgExceptionWhenArgIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            parser.createRacerFromString(null);
        });
    }
    
    @Test
    void shouldReturnIllArgExceptionWhenTimeFormatWrong() {
        assertThrows(IllegalArgumentException.class, () -> {
            parser.createRacerFromString("dd");
        });
    }
    
}
