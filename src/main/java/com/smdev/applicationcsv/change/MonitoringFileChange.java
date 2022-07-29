package com.smdev.applicationcsv.change;

import aQute.libg.tarjan.Tarjan.Node;
import com.google.inject.spi.Element;

import java.io.BufferedReader;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import static java.lang.Character.UnicodeBlock.of;

import java.util.Date;

import static javax.ws.rs.client.Entity.xml;

import org.apache.tika.exception.TikaException;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class MonitoringFileChange {




    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */


    public static void main(String[] args) throws IOException, SAXException, TikaException, ParserConfigurationException, XPathExpressionException {

//Считывание xml файла

        //Объект файла config.xml
        File configFile = new File("D:\\java\\config.xml");
        String[] Path = readConfig(configFile);

//То что мы получили из config.xml
        System.out.println("Входной путь: " + Path[0]);
        System.out.println("Выходной путь: " + Path[1]);

//Следить за изменением файла  config.xml---------------------------------------

        long millisec = configFile.lastModified();

        // date and time
        Date oldMod = new Date(millisec);

        System.out.println("Время последнего изменения: " + oldMod);

        boolean isCheck = true;

        int i = 0;

//Проверка на изменение---------------------------------------------------------
        while (isCheck) {

            long milliSecCur = configFile.lastModified();

            // date and time
            Date CurMod = new Date(milliSecCur);

            System.out.println("Время текущего изменения: " + CurMod);

            //System.out.println(oldMod);
            //System.out.println(CurMod);


            boolean isMod = (milliSecCur == millisec);

            boolean isModBig = (milliSecCur > millisec);

            // Если текущее не равно старому
            // Значит файл был изменен
            if (isMod == false) {

                i++;

                //Наш файл был изменен
                System.out.println("Config.xml has been changed");

                //Изменить объект с новым Modified
                File NewConfig = new File("D:\\java\\config.xml");

                //Опять просматривать файл
                Path = readConfig(NewConfig);

                //То что мы получили из config.xml
                System.out.println("Входной путь: " + Path[0]);
                System.out.println("Выходной путь: " + Path[1]);

                millisec = milliSecCur;

                if (i == 3) { // Ждать 3 изменения файла

                    break;

                }

            } //if

            //Наш файл был изменен
            System.out.println("Ждать изменений");

        }//while

        //Точка выхода из цикла
        System.out.println("Мы вышли из цикла");

    }//main

    static String[] readConfig(File NewConfig) throws FileNotFoundException, IOException {

        //Массив для входного и выходного пути
        String[] str = new String[2];

        if (NewConfig.exists()) { //Есть ли такой файл

            FileReader reader = new FileReader(NewConfig); //Reader для чтения файла
            BufferedReader br = new BufferedReader(reader); // Буфер памяти

            String line; //Строчка из файла

            String newInputDir = ""; //Новый входной путь
            String newOutputDir = ""; //Новый выходной путь

            while ((line = br.readLine()) != null) { // Пока не закончился config.xml

                //System.out.println(line); //Показать какая сейчас строчка активна

                boolean isIn = line.contains("<Input_dir>");
                boolean isOut = line.contains("<Output_dir>");

                if (isIn) { //Это секция <Input_dir>?

                    newInputDir = line.replace("<Input_dir>", "");
                    newInputDir = newInputDir.replace("</Input_dir>", "");

                    boolean isSt = newInputDir.startsWith(" "); //Начинается ли на " "

                    while (isSt) {

                        newInputDir = newInputDir.replace(" ", "");
                        isSt = newInputDir.startsWith(" ");
                    }

                    str[0] = newInputDir; //Результат: входной путь

                } else if (isOut) { //Это секция <Output_dir>?

                    newOutputDir = line.replace("<Output_dir>", "");
                    newOutputDir = newOutputDir.replace("</Output_dir>", "");

                    boolean isStart = newOutputDir.startsWith(" "); //Начинается ли на " "

                    while (isStart) {

                        newOutputDir = newOutputDir.replace(" ", "");
                        isStart = newOutputDir.startsWith(" ");
                    }

                    str[1] = newOutputDir; //Результат: выходной путь

                }

            }

            //Мои директории
            //System.out.println(newInputDir);
            //System.out.println(newOutputDir);

        } else { //Если config.xml нет, то будем его ждать

            System.out.println("Config.xml has't found");

        }

        //Вернуть массив: входной и выходной путь
        return str;
    }

}