package org.example.mockData;

import org.example.logarithmic.BaseNLog;

import java.util.Map;

public class BaseTenLogMock extends BaseNLog {
    private final Map<Double, Double> values = Map.of(
            0.1, -0.9999999999999997,
            0.5, -0.3010293397781902,
            2.0, 0.3010293397781902,
                3.0, 0.47711834074649817,
            Math.PI/2, 0.19611953214502556
    );

    public BaseTenLogMock() {
        super(10);
    }

    @Override
    public Double calculate(Double x, Double eps) {
        if (x <= 0) {
            throw new ArithmeticException("log10(x) is undefined at x = " + x);
        }

        if (!values.containsKey(x)) {
            throw new IllegalArgumentException("Нет мока логарифма 10 для x= " + x);
        }

        return values.get(x);
    }
}
