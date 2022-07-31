package com.smdev.applicationcsv.mapper;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import com.smdev.applicationcsv.model.Argument;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArgumentMapped
{

    public static Map<String, Integer> mapArgument = new HashMap<>();

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void parserArgument() throws FileNotFoundException {
        mapArgument.clear();
        CsvToBean csv = new CsvToBean();
        Path path = Path.of("src", "main", "resources", "argument.csv");
        CSVReader csvReader = new CSVReader(new FileReader(path.toFile()));
        List list = csv.parse(setColumMapping(), csvReader);
        for (Object object: list) {
            Argument argument = (Argument) object;
            mapArgument.put(argument.getName(), Integer.parseInt(argument.getValue()));
        }
    }
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static ColumnPositionMappingStrategy setColumMapping()
    {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Argument.class);
        String[] columns = new String[] {"name", "value"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}
