package org.example.mockData;

import org.example.function.AbstractFunction;

import java.util.Map;

public class TangentMock extends AbstractFunction {

    private final Map<Double, Double> values = Map.of(
            -Math.PI, 0.0,
            -Math.PI / 3, -Math.sqrt(3),
            -Math.PI / 4, -1.0,
            -2.0, 2.1850402589951203,
            -1.0, -1.5574078451143964,
            -0.5, -0.54630245578489

    );

    @Override
    public Double calculate(Double x, Double eps) {
        if (Math.abs(x + Math.PI / 2) < eps) {
            throw new ArithmeticException("tan(x) is undefined at x = " + x);
        }

        if (!values.containsKey(x)) {
            throw new IllegalArgumentException("Нет мока тангенса для x= " + x);
        }

        return values.get(x);
    }
}
