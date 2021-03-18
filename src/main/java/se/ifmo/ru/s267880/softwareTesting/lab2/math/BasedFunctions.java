package se.ifmo.ru.s267880.softwareTesting.lab2.math;

public class BasedFunctions {
    private static final double EPS = 1e-10;
    private static final int MAX_TERM_LIMIT = 100000000;
    // value copied from wolfram alpha with command `ln(2)`
    private static final double LN2 = 0.6931471805599453094172321214581765680755001343602552541206800094;
    private static final double PI = 3.141592653589793238462643383D;

    // the method used below cover for all x
    public static final Function sin = x -> {
        x = (x + PI) % (2 * PI) - PI;  // normalize all value to be in the period of 2PI from -PI to PI
        double res = 0;
        double term = x;
        double minusX2 = - x * x;

        for (int i = 1; Math.abs(term) > EPS && i < MAX_TERM_LIMIT; i += 2) {
            res += term;
            term = term * minusX2 / (i + 1) / (i + 2);
        }
        return res;
    };

    // the method used below is the expansion of ln(1 + x), but works only for -1 < x <= 1
    // In other word, ln(x) for 0 < x <= 2
    // to use that method for all x, we can use the property of logarithm:
    // ln(a * b) = ln(a) + ln(b)
    // So for x > 2, we can rewrite it like ln(x) = ln(2 * (x / 2)) = ln(2) + ln(x / 2)
    // We just continue divide x by 2 until x <= 2 and use the method
    // Note that there are another method but I'm not interested :).
    // They can be found here: http://math2.org/math/expansion/log.htm
    // The function clearly not defined for negative argument.
    public static final Function ln = x -> {
        if (x == 2) {
            return LN2;  // at less we have a very accurate value
        }
        if (x <= 0) {
            throw new IllegalArgumentException("Expected positive argument for logarithm, found " + x);
        }
        double res = 0;
        while (x > 2) {
            res += LN2;
            x /= 2;
        }

        x -= 1;
        double minusX = -x;
        double term = x;
        for (int i = 1; Math.abs(term / i) > EPS && i < MAX_TERM_LIMIT; ++i) {
            res += term / i;
            term *= minusX;
        }

        return res;
    };
}
