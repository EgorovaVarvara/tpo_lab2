package org.example.function;

import java.util.Objects;

public abstract class AbstractFunction {
    private static final int maxIterations = 1000;

    public AbstractFunction(){}

    protected void isValid(Double x, Double eps){
        Objects.requireNonNull(x, "Аргумент не должен быть null");
        Objects.requireNonNull(eps, "Погрешность не должна быть null");
    }

    public abstract Double calculate(Double x, Double eps);
}
