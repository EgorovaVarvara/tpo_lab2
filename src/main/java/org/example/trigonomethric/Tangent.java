package org.example.trigonomethric;

import org.example.function.AbstractFunction;

public class Tangent extends AbstractFunction {

    private final Sinus sinus;
    private final Cosine cosine;

    public Tangent(){
        super();
        this.sinus = new Sinus();
        this.cosine = new Cosine(sinus);
    }

    public Tangent(Sinus sinus, Cosine cosine){
        super();
        this.sinus = sinus;
        this.cosine = cosine;
    }

    @Override
    public Double calculate(Double x, Double eps) throws ArithmeticException{
        isValid(x, eps);

        Double sinX = sinus.calculate(x, eps);
        Double cosX = cosine.calculate(x, eps);

        if (Math.abs(cosX) < eps){
            throw new ArithmeticException("tan(x) is undefined at x = " + x);
        }

        return sinX / cosX;
    }
}
