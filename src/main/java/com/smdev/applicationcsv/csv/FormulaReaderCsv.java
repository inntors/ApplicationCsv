package com.smdev.applicationcsv.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class FormulaReaderCsv {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Formula formula = new Formula();

        Path path = Path.of("src", "main", "resources", "formula.csv");

        List<Formula> formulaList = Files.lines(path)
                .map(FormulaReaderCsv::getFormula)
                .collect(Collectors.toList());

        System.out.println(formulaList);
    }

    private static Formula getFormula(String line) {
        String[] fields = line.split(",");
        return new Formula(fields[0]);
    }
}

