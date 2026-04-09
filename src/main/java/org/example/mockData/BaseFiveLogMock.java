package org.example.mockData;

import org.example.logarithmic.BaseNLog;

import java.util.Map;

public class BaseFiveLogMock extends BaseNLog {
    private final Map<Double, Double> values = Map.of(
            0.1, -1.4306826918805282,
            0.5, -0.4306774661688795,
            2.0, 0.4306774661688795,
            3.0, 0.6826049520847713,
            Math.PI/2, 0.2805848201795951
    );

    public BaseFiveLogMock() {
        super(5);
    }

    @Override
    public Double calculate(Double x, Double eps) {
        if (x <= 0) {
            throw new ArithmeticException("log5(x) is undefined at x = " + x);
        }

        if (!values.containsKey(x)) {
            throw new IllegalArgumentException("Нет мока логарифма 5 для x= " + x);
        }

        return values.get(x);
    }
}
