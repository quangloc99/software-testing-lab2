package se.ifmo.ru.s267880.softwareTesting.lab2.math;

public class LogarithmMathBuilder {
    private Function ln;
    private Function log2;

    public LogarithmMathBuilder setLn(Function ln) {
        this.ln = ln;
        return this;
    }

    public LogarithmMathBuilder setLog2(Function log2) {
        this.log2 = log2;
        return this;
    }

    public LogarithmMath build() {
        return new LogarithmMath(ln, log2);
    }
}