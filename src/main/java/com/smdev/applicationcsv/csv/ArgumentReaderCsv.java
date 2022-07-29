package com.smdev.applicationcsv.csv;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ArgumentReaderCsv {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("src", "main", "resources", "arguments.csv");
//        Path path = Path.of("src", "main", "resources", "formula.csv");
        List<Argument> argumentList = Files.lines(path)
                .skip(1)
                .map(ArgumentReaderCsv::getArgument)
                .collect(Collectors.toList());
        System.out.println(argumentList);
    }

    private static Argument getArgument(String line) {
        String[] fields = line.split(",");
        return new Argument(fields[0], Integer.parseInt(fields[1]));
    }
}
