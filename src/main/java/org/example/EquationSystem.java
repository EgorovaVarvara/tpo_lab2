package org.example;

import org.example.function.AbstractFunction;
import org.example.logarithmic.BaseNLog;
import org.example.logarithmic.NatLog;
import org.example.trigonomethric.*;

public class EquationSystem extends AbstractFunction {

    private final Sinus sin;
    private final Cosine cos;
    private final Tangent tan;
    private final Cotangent cot;
    private final Secant sec;
    private final NatLog LogN;
    private final BaseNLog Log2;
    private final BaseNLog Log5;
    private final BaseNLog Log10;

    public EquationSystem(){
        super();
        sin = new Sinus();
        cos = new Cosine(sin);
        tan = new Tangent(sin, cos);
        cot = new Cotangent(sin, cos);
        sec = new Secant(cos);
        LogN = new NatLog();
        Log2 = new BaseNLog(2, LogN);
        Log5 = new BaseNLog(5, LogN);
        Log10 = new BaseNLog(10, LogN);
    }

    @Override
    public Double calculate(Double x, Double eps) throws ArithmeticException{
        isValid(x, eps);

        try{
            if (x <= 0){
                return (Math.pow(c(cos, x, eps), 2) + c(cos, x, eps)) * c(sec, x, eps)
                        + c(tan, x, eps)
                        + Math.pow((c(sec, x, eps) - c(cot, x, eps)) / c(sin, x, eps), 3);
            } else {
                return Math.pow(((c(Log2, x, eps) - c(Log5, x, eps))/c(Log5, x, eps) +
                        2 * c(LogN, x, eps)) * c(Log10, x, eps), 3);
            }
        } catch (ArithmeticException e){
            throw new ArithmeticException("Function is undefined because " + e.getMessage());
        }
    }

    private Double c(AbstractFunction f, Double x, Double eps){
        return f.calculate(x, eps);
    }
}
