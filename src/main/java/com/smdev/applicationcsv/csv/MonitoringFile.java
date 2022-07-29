package com.smdev.applicationcsv.csv;

import java.io.File;
import java.util.Date;

public class MonitoringFile {
    public static void main(String[] args) {
        //Считывание csv файла

        //Объект файла data.csv
        File configFile = new File("src/main/resources/data.csv");

        //Следить за изменением файла data.csv
        long millisec = configFile.lastModified();
        Date oldMod = new Date(millisec);

//    System.out.println("Время последнего изменения: "+oldMod);

        boolean isCheck = true;

        int i = 0;

        //Проверка на изменение---------------------------------------------------------

        while (isCheck) {

            long milliSecCur = configFile.lastModified();

            // date and time
            Date CurMod = new Date(milliSecCur);

            System.out.println("Время текущего изменения: " + CurMod);

            System.out.println("Time stamp = " + configFile.lastModified());

            boolean isMod = (milliSecCur == millisec);
            if (!isMod) {
                System.out.println("delta = " + (milliSecCur - millisec));
                break;
            }
        }
    }
}