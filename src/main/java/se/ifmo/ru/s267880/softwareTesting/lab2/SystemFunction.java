package se.ifmo.ru.s267880.softwareTesting.lab2;

import java.util.Objects;

import se.ifmo.ru.s267880.softwareTesting.lab2.math.*;

public class SystemFunction implements Function {
    private TrigonometricMath trigMath;
    private LogarithmMath logMath;

    public SystemFunction(TrigonometricMath trigMath, LogarithmMath logMath) {
        Objects.requireNonNull(trigMath);
        Objects.requireNonNull(logMath);
        this.trigMath = trigMath;
        this.logMath = logMath;
    }

    @Override
    public double calculate(double x) {
        if (x <= 0) {
            return calNonPositive(x);
        } else {
            return calPositive(x);
        }
    }

    // helper functions
    private double sqr(double x) {
        return x * x;
    }

    private double cube(double x) {
        return x * x * x;
    }

    // (((((csc(x) ^ 2) - sec(x)) ^ 3) * ((csc(x) - (sin(x) ^ 3)) / (sin(x) * cot(x)))) + (((cos(x) + tan(x)) + sin(x)) ^ 2))
    private double calNonPositive(double x) {
        double sinX = trigMath.sin.calculate(x);
        double cosX = trigMath.cos.calculate(x);
        double cscX = trigMath.csc.calculate(x);
        double secX = trigMath.sec.calculate(x);
        double tanX = trigMath.tan.calculate(x);
        double cotX = trigMath.cot.calculate(x);

        return cube(sqr(cscX) - secX) * (cscX - cube(sinX)) / (sinX * cotX) +
                sqr(cosX + tanX + sinX);
    }

    // (((((ln(x) ^ 3) + log_2(x)) - log_2(x)) + log_2(x)) ^ 2)
    private double calPositive(double x) {
        double lnX = logMath.ln.calculate(x);
        double l2X = logMath.log2.calculate(x);

        return sqr(cube(lnX) + l2X - l2X + l2X);  // Such function!
    }
}
