package com.smdev.applicationcsv.csv;

import java.io.File;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        File configFile = new File("src/main/resources/data.csv");

        long millisec = configFile.lastModified();
        Date oldMod = new Date(millisec);

        boolean isCheck = true;

        int i = 0;

        while (isCheck) {

        }
    }

}
