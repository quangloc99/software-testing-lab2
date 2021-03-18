package se.ifmo.ru.s267880.softwareTesting.lab2.math;

import org.junit.Test;

public class TestBasedLnException {
    @Test(expected = IllegalArgumentException.class)
    public void testZero() {
        BasedFunctions.ln.calculate(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinus1() {
        BasedFunctions.ln.calculate(-1);
    }
}
