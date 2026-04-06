package org.example.trigonomethric;

import org.example.function.AbstractFunction;

public class Sinus extends AbstractFunction {

    public Sinus(){
        super();
    }

    @Override
    public Double calculate(Double x, Double eps){
        isValid(x, eps);

        x = x % (2 * Math.PI);
        if (x > Math.PI) {
            x -= 2 * Math.PI;
        } else if (x < -Math.PI) {
            x += 2 * Math.PI;
        }

        Double result = x;
        Double term = x;
        Double x2 = x * x;

        int i = 1;

        while (Math.abs(term) > eps) {
            term *= x2 / ((2.0 * i) * (2.0 * i + 1));
            result += term * (i % 2 == 0 ? 1 : -1);
            i++;
        }

        return result;
    }
}
