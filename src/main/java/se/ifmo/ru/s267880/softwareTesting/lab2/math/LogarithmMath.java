package se.ifmo.ru.s267880.softwareTesting.lab2.math;

public class LogarithmMath {
    // using the public final field because the field actually acted just like normal methods.
    // so we can use them like this:
    // var logMath = <a LogarithmMath>;
    // logMath.ln.calculate(123);
    public final Function ln;
    public final Function log2;

    LogarithmMath(Function ln, Function log2) {
        this.ln = ln;
        this.log2 = log2;
    }

    public static LogarithmMath createWithLn(Function ln) {
        return new LogarithmMath(ln, x -> ln.calculate(x) / ln.calculate(2));
    }
}
