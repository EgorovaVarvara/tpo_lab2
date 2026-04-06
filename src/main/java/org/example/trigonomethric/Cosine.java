package org.example.trigonomethric;

import org.example.function.AbstractFunction;

public class Cosine extends AbstractFunction {

    private final Sinus sinus;

    public Cosine(){
        super();
        this.sinus = new Sinus();
    }

    public Cosine(Sinus sinus){
        super();
        this.sinus = sinus;
    }

    @Override
    public Double calculate(Double x, Double eps) {
        isValid(x, eps);
        Double newX = Math.PI / 2 - x;

        return sinus.calculate(newX, eps);
    }
}
