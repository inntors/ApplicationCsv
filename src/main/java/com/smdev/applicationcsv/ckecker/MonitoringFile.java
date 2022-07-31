package com.smdev.applicationcsv.ckecker;

import java.io.File;

public class MonitoringFile {
    private static long lastTime = 0;
    public boolean runMonitoring() {
        File configFile = new File("src/main/resources/formula.csv");

        if (lastTime == 0) {
            lastTime = configFile.lastModified();
            return false;
        }
        long millisec = configFile.lastModified();
        boolean isMod = (lastTime == millisec);
        if (!isMod) {
            lastTime = millisec;
        }
        return isMod;
    }
}
