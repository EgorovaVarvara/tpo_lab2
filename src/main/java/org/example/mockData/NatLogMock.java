package org.example.mockData;

import org.example.function.AbstractFunction;

import java.util.Map;

public class NatLogMock extends AbstractFunction {
    private final Map<Double, Double> values = Map.of(
            0.1, -2.3025488407309926,
            0.5, -0.6931347573322881,
            2.0, 0.6931347573322881,
                3.0, 1.0985882823773445,
            Math.PI/2, 0.4515748013852334
    );

    @Override
    public Double calculate(Double x, Double eps) {
        if (x <= 0) {
            throw new ArithmeticException("ln(x) is undefined at x = " + x);
        }

        if (!values.containsKey(x)) {
            throw new IllegalArgumentException("Нет мока нат логарифма для x= " + x);
        }

        return values.get(x);
    }
}
