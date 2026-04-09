package org.example.mockData;

import org.example.function.AbstractFunction;
import org.example.trigonomethric.Cosine;
import org.example.trigonomethric.Sinus;

import java.util.Map;

public class CotangentMock extends AbstractFunction {
    private final Map<Double, Double> values = Map.of(
            -Math.PI / 3, -Math.sqrt(3)/3,
            -Math.PI / 4, -1.0,
            -Math.PI / 2, 0.0,
            -2.0, 0.45765747147372504,
            -1.0, -0.6420925662709,
            -0.5, -1.83048782917
    );


    @Override
    public Double calculate(Double x, Double eps) {
        if (Math.abs(x) < eps || Math.abs(x + Math.PI) < eps) {
            throw new ArithmeticException("cot(x) is undefined at x = " + x);
        }

        if (!values.containsKey(x)) {
            throw new IllegalArgumentException("нет мока котангенса для x= " + x);
        }

        return values.get(x);
    }
}
