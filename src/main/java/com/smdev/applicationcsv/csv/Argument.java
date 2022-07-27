package com.smdev.applicationcsv.csv;

public class Argument {

    private final String name;
    private final Integer value;

    public Argument(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\nArgument: " +
                "name='" + name + '\'' +
                ", value=" + value;
    }
}
