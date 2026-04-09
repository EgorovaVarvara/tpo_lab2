package org.example;

import org.example.csvUtil.CSVWriter;
import org.example.logarithmic.BaseNLog;
import org.example.logarithmic.NatLog;
import org.example.trigonomethric.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Sinus sin = new Sinus();
        Cosine cos = new Cosine();
        NatLog ln = new NatLog();
        EquationSystem eq = new EquationSystem(
                sin,
                cos,
                new Secant(cos),
                new Tangent(sin, cos),
                new Cotangent(sin, cos),
                ln,
                new BaseNLog(2, ln),
                new BaseNLog(5, ln),
                new BaseNLog(10, ln));
        Double x = 0.1;
        Double x2 = 1.0;
        Double eps = 0.00001;
        eq.calculate(x, eps);
//        System.out.println(new BaseNLog(2, ln).calculate(0.1,  0.00001));
        System.out.println(eq.calculate(x, eps));

        // Пример использования врайтера
        CSVWriter writer = new CSVWriter(eq);
        writer.write(x, x2, 0.1, eps);
    }
}