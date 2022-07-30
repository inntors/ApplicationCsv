package com.smdev.applicationcsv.csv;

import java.io.File;
import java.util.Date;

public class MonitoringFile implements Runnable {
    @Override
    public void run() {
        File configFile = new File("src/main/resources/data.csv");
        long millisec = configFile.lastModified();
        Date oldMod = new Date(millisec);
        boolean isCheck = true;
        while (isCheck) {
            long milliSecCur = configFile.lastModified();
            // date and time
            Date CurMod = new Date(milliSecCur);
            boolean isMod = (milliSecCur == millisec);
//            if (!isMod) {
//                break;
//            }
        }
    }
}