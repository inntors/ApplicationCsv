package com.smdev.applicationcsv.mapper;

import com.smdev.applicationcsv.model.Argument;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgumentMappedTest {

    @Test
    public void addArgumentTest(){
        Argument argument = new Argument("a", "1");
        assertEquals("1", argument.getValue());
    }
}
