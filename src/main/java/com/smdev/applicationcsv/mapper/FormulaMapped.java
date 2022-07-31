package com.smdev.applicationcsv.mapper;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import com.smdev.applicationcsv.model.Formula;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FormulaMapped {

    public static List<Formula> listFormula = new ArrayList<>();

    public void run() {
        listFormula.clear();
        CsvToBean csv = new CsvToBean();
        Path path = Path.of("src", "main", "resources", "formula.csv");
        CSVReader csvReader;
        try {
            csvReader = new CSVReader(new FileReader(path.toFile()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List list = csv.parse(setColumMapping(), csvReader);
        for (Object object : list) {
            Formula formula = (Formula) object;
            listFormula.add(formula);
        }
    }

    private static ColumnPositionMappingStrategy setColumMapping() {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Formula.class);
        String[] columns = new String[]{"value"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}

