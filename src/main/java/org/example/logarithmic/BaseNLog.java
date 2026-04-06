package org.example.logarithmic;

import org.example.function.AbstractFunction;

public class BaseNLog extends AbstractFunction {

    private final NatLog nLog;
    private final int base;

    public BaseNLog(){
        this.nLog = new NatLog();
        this.base = 10;
    }

    public BaseNLog(int base){
        this.nLog = new NatLog();
        this.base = base;
    }

    public BaseNLog(int base, NatLog nLog){
        this.nLog = nLog;
        this.base = base;
    }

    @Override
    public Double calculate(Double x, Double eps) throws ArithmeticException{
        isValid(x, eps);

        if (x <= 0) throw new ArithmeticException("Logarithm is undefined at x = " + x);
        if (base <= 0 || base == 1) throw new ArithmeticException("Logarithm with base = " + base + " is undefined");

        Double lnX = nLog.calculate(x, eps);
        Double lnN = nLog.calculate((double) this.base, eps);

        return lnX / lnN;
    }
}
