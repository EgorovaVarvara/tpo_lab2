package org.example;

import org.example.function.AbstractFunction;
import org.example.logarithmic.BaseNLog;
import org.example.logarithmic.NatLog;
import org.example.trigonomethric.*;

public class EquationSystem extends AbstractFunction {

    private final AbstractFunction sinus;
    private final AbstractFunction cosinus;
    private final AbstractFunction tangent;
    private final AbstractFunction cotangent;
    private final AbstractFunction secant;
    private final AbstractFunction natLog;
    private final AbstractFunction log2;
    private final AbstractFunction log5;
    private final AbstractFunction log10;
    public EquationSystem(
            AbstractFunction sin,
            AbstractFunction cos,
            AbstractFunction sec,
            AbstractFunction tan,
            AbstractFunction cot,
            AbstractFunction ln,
            AbstractFunction log2,
            AbstractFunction log5,
            AbstractFunction log10
    ) {
        super();
        this.sinus = sin;
        this.cosinus = cos;
        this.secant = sec;
        this.tangent = tan;
        this.cotangent = cot;
        this.natLog = ln;
        this.log2 = log2;
        this.log5 = log5;
        this.log10 = log10;
    }



    @Override
    public Double calculate(Double x, Double eps) throws ArithmeticException{
        isValid(x, eps);

        try{
            if (x == 1) throw new ArithmeticException("there is division by 0 if x = 1");
            if (x <= 0){
                return (Math.pow(c(cosinus, x, eps), 2) - c(cosinus, x, eps)) * c(secant, x, eps)
                        + c(tangent, x, eps)
                        + Math.pow((c(secant, x, eps) - c(cotangent, x, eps)) / c(sinus, x, eps), 3);
            } else {
                return Math.pow(((c(log2, x, eps) - c(log5, x, eps))/c(log5, x, eps) +
                        2 * c(natLog, x, eps)) * c(log10, x, eps), 3);
            }
        } catch (ArithmeticException e){
            throw new ArithmeticException("Function is undefined because " + e.getMessage());
        }
    }

    private Double c(AbstractFunction f, Double x, Double eps){
        return f.calculate(x, eps);
    }
}
