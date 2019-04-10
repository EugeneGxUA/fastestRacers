package com.foxminded.fastestRacers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FastestRacersGenerator {
    
    public String generateRacersBoard(Stream<String> startLogStream, 
            Stream<String> endLogStream, Stream<String> abbreviationsStream) {

        StringBuilder builder = new StringBuilder();

        generateRacers(startLogStream, endLogStream, abbreviationsStream).sorted((r1, r2) -> {
            return r1.fastestLap.compareTo(r2.fastestLap);
        }).forEachOrdered(new Consumer<Racer>() {
            int index = 1;

            @Override
            public void accept(Racer racer) {
                builder.append(index + ". " + racer).append("\n");
                if (index == 15) {
                    builder.append("------------------------------------------------------------------------")
                            .append("\n");
                }
                index++;
            }

        });

        return builder.toString();
    }

    private Stream<Racer> generateRacers(Stream<String> startLogStream, 
            Stream<String> endLogStream, Stream<String> abbreviationsStream) {
        
        List<String> startLogList = startLogStream.collect(Collectors.toList());
        List<String> endLogList = endLogStream.collect(Collectors.toList());

        return abbreviationsStream.map(line -> {
            String[] arr = line.split("_");
            return new Racer(arr[1], arr[2], calculateDuration(startLogList, endLogList, arr[0]));
        });
    }

    private Duration calculateDuration(List<String> startFileStream, List<String> endFileStream, String abbreviation) {
        return Duration.between(getLogDate(startFileStream, abbreviation), getLogDate(endFileStream, abbreviation));
    }

    private LocalDateTime getLogDate(List<String> list, String abbreviation) {
        String line = list.stream().filter(l -> l.startsWith(abbreviation)).findAny().orElseThrow();

        String dateAndTime = line.substring(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
        LocalDateTime dateTime = LocalDateTime.parse(dateAndTime, formatter);
        return dateTime;
    }

    private class Racer {
        private String name;
        private String commandName;

        private Duration fastestLap;

        public Racer(String name, String commandName, Duration fastestLap) {
            this.name = name;
            this.commandName = commandName;
            this.fastestLap = fastestLap;
        }

        @Override
        public String toString() {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("mm:ss.SSS");
            LocalTime time = LocalTime.ofNanoOfDay(fastestLap.toNanos());
            String timeOutput = time.format(df);

            return name + " | " + commandName + " | " + timeOutput;
        }
    }

}
