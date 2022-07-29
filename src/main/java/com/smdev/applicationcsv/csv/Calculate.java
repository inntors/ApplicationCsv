package com.smdev.applicationcsv.csv;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Calculate {






    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService exec = Executors.newFixedThreadPool(1);
        ////        Expression e = new ExpressionBuilder("3log(y)/(x+1)")
//        Expression e = new ExpressionBuilder("x/z")
        Expression e = new ExpressionBuilder("x+y")
                .variables("x", "y")
                .build()
                .setVariable("x", 12)
                .setVariable("y", 3);
        Future<Double> future = e.evaluateAsync(exec);
        double result = future.get();

        System.out.println(result);
    }
}
