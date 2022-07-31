package com.smdev.applicationcsv.mapper;

import com.smdev.applicationcsv.model.Formula;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormulaMappedTest {

    @Test
    public void addFormulaTest(){
        Formula formula = new Formula();
        formula.setValue("a+b+c");
        assertEquals("a+b+c", formula.getValue());
    }
}