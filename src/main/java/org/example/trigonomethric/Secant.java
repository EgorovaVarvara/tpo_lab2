package org.example.trigonomethric;

import org.example.function.AbstractFunction;

public class Secant extends AbstractFunction {

    private final Cosine cosine;

    public Secant(){
        super();
        this.cosine = new Cosine();
    }

    public Secant(Cosine cosine){
        super();
        this.cosine = cosine;
    }

    @Override
    public Double calculate(Double x, Double eps) throws ArithmeticException{
        isValid(x, eps);

        Double cosX = cosine.calculate(x, eps);

        if (Math.abs(cosX) < eps){
            throw new ArithmeticException("sec(x) is undefined at x = " + x);
        }

        return 1/cosX;
    }
}
