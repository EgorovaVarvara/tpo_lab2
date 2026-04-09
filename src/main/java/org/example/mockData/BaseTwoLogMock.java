package org.example.mockData;

import org.example.function.AbstractFunction;
import org.example.logarithmic.BaseNLog;

import java.util.Map;

public class BaseTwoLogMock extends BaseNLog {
    private final Map<Double, Double> values = Map.of(
            0.1, -3.3219353327381227,
            0.5, -1.0,
            2.0, 1.0,
            3.0, 1.5849562740231802,
            Math.PI/2, 0.6514964032726307
    );

    public BaseTwoLogMock() {
        super(2);
    }

    @Override
    public Double calculate(Double x, Double eps) {
        if (x <= 0) {
            throw new ArithmeticException("log2(x) is undefined at x = " + x);
        }

        if (!values.containsKey(x)) {
            throw new IllegalArgumentException("Нет мока логарифма 2 для x= " + x);
        }

        return values.get(x);
    }
}
