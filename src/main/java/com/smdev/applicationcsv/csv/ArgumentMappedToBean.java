package com.smdev.applicationcsv.csv;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import com.smdev.applicationcsv.model.Argument;

import java.io.FileReader;
import java.util.List;

public class ArgumentMappedToBean
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) throws Exception
    {
        CsvToBean csv = new CsvToBean();
        String csvFilename = "src/main/resources/arguments.csv";
        CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
        //Set column mapping strategy
        List list = csv.parse(setColumMapping(), csvReader);
        for (Object object: list) {
            Argument argument = (Argument) object;
            System.out.println(argument);
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
