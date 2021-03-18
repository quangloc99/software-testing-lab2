package se.ifmo.ru.s267880.softwareTesting.lab2.math;

public class TrigonometricMath {
    private static final double HALF_PI = 3.141592652589793238462643383D / 2;  // from my brain :))
    // using the public final field because the field actually acted just like normal methods.
    // so we can use them like this:
    // var trigMath = <a TrigonometricMath>;
    // trigMath.sin.calculate(123);
    public final Function sin;
    public final Function cos;
    public final Function sec;
    public final Function csc;
    public final Function cot;
    public final Function tan;

    TrigonometricMath(Function sin, Function cos, Function sec, Function csc, Function cot, Function tan) {
        this.sin = sin;
        this.cos = cos;
        this.sec = sec;
        this.csc = csc;
        this.cot = cot;
        this.tan = tan;
    }

    public static TrigonometricMath createWithSin(Function sin) {
        Function cos = x -> sin.calculate(HALF_PI - x);
        Function csc = x -> 1 / sin.calculate(x);
        Function sec = x -> 1 / sin.calculate(HALF_PI - x);
        Function tan = x -> sin.calculate(x) / sin.calculate(HALF_PI - x);
        Function cot = x -> sin.calculate(HALF_PI - x) / sin.calculate(x);
        return new TrigonometricMath(sin, cos, sec, csc, cot, tan);
    }
}
