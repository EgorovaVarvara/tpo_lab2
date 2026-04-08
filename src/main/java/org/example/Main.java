package org.example;

import org.example.csvUtil.CSVWriter;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        EquationSystem eq = new EquationSystem();
        Double x = -1.0;
        Double x2 = 1.0;
        Double eps = 0.00001;
        System.out.println(eq.calculate(x, eps));

        // Пример использования врайтера

        CSVWriter writer = new CSVWriter(eq);
        writer.write(x, x2, 0.1, eps);
    }
}