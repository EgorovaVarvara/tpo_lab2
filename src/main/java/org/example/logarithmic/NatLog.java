package org.example.logarithmic;

import org.example.function.AbstractFunction;

public class NatLog extends AbstractFunction {

    public NatLog(){
        super();
    }

    @Override
    public Double calculate(Double x, Double eps) throws ArithmeticException{
        isValid(x, eps);

        if (x <= 0){
            throw new ArithmeticException("Natural logarithm is undefined at x = " + x);
        }

        double y = (x - 1) / (x + 1);
        double y2 = y * y;

        double term = y;
        double result = 0.0;
        int i = 1;

        while (Math.abs(term / i) > eps) {
            result += term / i;
            term *= y2;
            i += 2;
        }

        return 2 * result;
    }
}
