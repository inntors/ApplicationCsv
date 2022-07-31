package com.smdev.applicationcsv;

import com.smdev.applicationcsv.ckecker.MonitoringFile;
import com.smdev.applicationcsv.mapper.ArgumentMapped;
import com.smdev.applicationcsv.mapper.FormulaMapped;
import com.smdev.applicationcsv.model.Formula;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ArgumentMapped.parserArgument();

        while (true) {
            MonitoringFile monitoring = new MonitoringFile();

            if (!monitoring.runMonitoring()) {
                FormulaMapped formulaMappedToBean = new FormulaMapped();
                formulaMappedToBean.run();
                for (Formula formula : FormulaMapped.listFormula) {

                    System.out.println(formula);

                    String value = formula.getValue();
                    extracted(value);
                }
            }
        }
    }

    private static void extracted(String value) {
        Expression e = new ExpressionBuilder(value)
                .variables(ArgumentMapped.mapArgument.keySet())
                .build()
                .setVariable("a", ArgumentMapped.mapArgument.get("a"))
                .setVariable("b", ArgumentMapped.mapArgument.get("b"))
                .setVariable("c", ArgumentMapped.mapArgument.get("c"))
                .setVariable("d", ArgumentMapped.mapArgument.get("d"));
        double result = e.evaluate();
        System.out.println("result: " + result);
    }
}
