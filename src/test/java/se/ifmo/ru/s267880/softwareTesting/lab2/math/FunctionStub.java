package se.ifmo.ru.s267880.softwareTesting.lab2.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FunctionStub implements Function {
    public static final double EPS = 1e-8;  // can be set so make I make it public

    private final ArrayList<Double> xValues = new ArrayList<>();
    private final ArrayList<Double> yValues = new ArrayList<>();

    @Override
    public double calculate(double x) {
        for (int i = 0; i < xValues.size(); ++i) {
            if (Math.abs(xValues.get(i) - x) < EPS) {
                return yValues.get(i);
            }
        }
        throw new RuntimeException("There are no defined lookup value");
    }

    public FunctionStub addValues(double[][] values) {
        for (double[] point: values) {
            xValues.add(point[0]);
            yValues.add(point[1]);
        }
        return this;
    }
}
