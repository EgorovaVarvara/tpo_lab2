package org.example.mockData;

import org.example.function.AbstractFunction;

import java.util.Map;

public class CosineMock extends AbstractFunction {
    private final Map<Double, Double> values = Map.of(
            -Math.PI, -1.0,
            -Math.PI / 2, 0.0,
            -Math.PI / 3, 0.5,
            -Math.PI / 4, Math.sqrt(2)/2,
            -2.0, -0.416146772479996,
            -1.0, 0.5403022800609867,
            -0.5, 0.877582603457
    );

    @Override
    public Double calculate(Double x, Double eps) {
        if (!values.containsKey(x)) {
            throw new IllegalArgumentException("Нет мока косинуса для x= " + x);
        }

        return values.get(x);
    }
}
