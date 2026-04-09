package org.example.mockData;

import org.example.function.AbstractFunction;

import java.util.Map;

public class SinusMock extends AbstractFunction {
    private final Map<Double, Double> values = Map.of(
            -Math.PI, 0.0,
            -Math.PI / 2, -1.0,
            -Math.PI / 3, -(Math.sqrt(3)/2),
            -Math.PI / 4, -(Math.sqrt(2)/2),
            -2.0, -0.9092974515,
            -1.0, -0.8414710097001764,
            -0.5, -0.4794255332341
    );

    @Override
    public Double calculate(Double x, Double eps) {
        if (!values.containsKey(x)) {
            throw new IllegalArgumentException("Нет мока синуса для x= " + x);
        }

        return values.get(x);
    }
}
