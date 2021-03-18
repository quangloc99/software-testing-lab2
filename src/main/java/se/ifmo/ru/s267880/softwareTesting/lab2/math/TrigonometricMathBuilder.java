package se.ifmo.ru.s267880.softwareTesting.lab2.math;

public class TrigonometricMathBuilder {
    private Function sin;
    private Function cos;
    private Function sec;
    private Function csc;
    private Function cot;
    private Function tan;

    public TrigonometricMathBuilder setSin(Function sin) {
        this.sin = sin;
        return this;
    }

    public TrigonometricMathBuilder setCos(Function cos) {
        this.cos = cos;
        return this;
    }

    public TrigonometricMathBuilder setSec(Function sec) {
        this.sec = sec;
        return this;
    }

    public TrigonometricMathBuilder setCsc(Function csc) {
        this.csc = csc;
        return this;
    }

    public TrigonometricMathBuilder setCot(Function cot) {
        this.cot = cot;
        return this;
    }

    public TrigonometricMathBuilder setTan(Function tan) {
        this.tan = tan;
        return this;
    }

    public TrigonometricMath build() {
        return new TrigonometricMath(sin, cos, sec, csc, cot, tan);
    }
}