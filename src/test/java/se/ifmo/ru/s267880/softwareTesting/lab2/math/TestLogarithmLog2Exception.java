package se.ifmo.ru.s267880.softwareTesting.lab2.math;

import org.junit.Test;

public class TestLogarithmLog2Exception {
    public static final LogarithmMath logMath = LogarithmMath.createWithLn(new LnStub());

    @Test(expected = IllegalArgumentException.class)
    public void testZero() {
        logMath.log2.calculate(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegative() {
        logMath.log2.calculate(-1);
    }
}
