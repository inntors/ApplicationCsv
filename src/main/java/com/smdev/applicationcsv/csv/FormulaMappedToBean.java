package com.smdev.applicationcsv.csv;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import com.smdev.applicationcsv.model.Formula;
import com.smdev.applicationcsv.model.Formula;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Component
public class FormulaMappedToBean {
    public static void main(String[] args) throws FileNotFoundException {

        CsvToBean csv = new CsvToBean();
        String csvFilename = "src/main/resources/data.csv";
        CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
        //Set column mapping strategy
        List list = csv.parse(setColumMapping(), csvReader);
        for (Object object : list) {
            Formula formula = (Formula) object;
            System.out.println(formula);
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static ColumnPositionMappingStrategy setColumMapping() {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Formula.class);
        String[] columns = new String[]{"value"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}

