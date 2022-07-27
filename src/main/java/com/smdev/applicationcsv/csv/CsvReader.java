package com.smdev.applicationcsv.csv;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CsvReader {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("src", "main", "resources", "arguments.csv");
        List<Argument> argumentList = Files.lines(path)
                .skip(1)
                .map(CsvReader::getArgument)
                .collect(Collectors.toList());
        System.out.println(argumentList);
    }

    private static Argument getArgument(String line) {
        String[] fields = line.split(",");
        return new Argument(fields[0], Integer.parseInt(fields[1]));
    }
}
