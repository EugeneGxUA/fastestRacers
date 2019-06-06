package com.foxminded.formula_one.reports.models;

import java.time.Duration;
import java.time.LocalDateTime;

public class Lap implements Comparable<Lap> {
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    
    private Duration fastestLap;
    
    private Racer racer;
    
    public Lap(LocalDateTime startDateTime, LocalDateTime endDateTime, Duration fastestLap, Racer racer) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.racer = racer;
        this.fastestLap = fastestLap;
    }
    
    public Racer getRacer() {
        return racer;
    }
    
    public Duration getFastestLap() {
        return fastestLap;
    }
    
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }
    
    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    @Override
    public int compareTo(Lap lap) {
        if (lap == null) {
            return -1;
        }
        
        return this.fastestLap.compareTo(lap.fastestLap);
    }
}
