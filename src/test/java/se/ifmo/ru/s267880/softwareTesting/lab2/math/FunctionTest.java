package se.ifmo.ru.s267880.softwareTesting.lab2.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class FunctionTest {
    public static final String PARAM_NAME = "x = {0}; f(x) = {1}";
    public static final double EPS = 1e-6;

    protected final double x;
    protected final double result;
    protected final Function func;
    public FunctionTest(double x, double result, Function func) {
        this.x = x;
        this.result = result;
        this.func = func;
    }

    @Test
    public void testValue() {
        // there are some value that produce very big result
        // therefore we must use relative error.
        // relative error = absolute error /  abs(expected)
        // so absolute error should now be relative error * abs(expected).
        // hence the delta will be
        double delta = EPS * Math.abs(result);
        assertEquals(result, func.calculate(x), delta);
    }
}
