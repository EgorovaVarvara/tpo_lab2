package org.example.mockData;

import org.example.function.AbstractFunction;
import org.example.trigonomethric.Cosine;

import java.util.Map;

public class SecantMock extends AbstractFunction {

//    private final CosineMock cosineMock;
    private final Map<Double, Double> values = Map.of(
            -Math.PI, -1.0,
            -Math.PI / 3, 2.0,
            -Math.PI / 4, Math.sqrt(2),
        -2.0, -2.402998331671717,
        -1.0, 1.8508158060838,
        -0.5, 1.1394938733523474
    );

//    public SecantMock(CosineMock cosineMock){
//        super();
//        this.cosineMock = cosineMock;
//    }

    @Override
    public Double calculate(Double x, Double eps) {
        if (Math.abs(x + Math.PI / 2) < eps) {
            throw new ArithmeticException("sec(x) is undefined at x = " + x);
        }

        if (!values.containsKey(x)) {
            throw new IllegalArgumentException("Нет мока секанса для x= " + x);
        }

        return values.get(x);
    }
}
