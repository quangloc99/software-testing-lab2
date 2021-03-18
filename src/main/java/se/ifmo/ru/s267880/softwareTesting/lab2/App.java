package se.ifmo.ru.s267880.softwareTesting.lab2;

import se.ifmo.ru.s267880.softwareTesting.lab2.math.BasedFunctions;
import se.ifmo.ru.s267880.softwareTesting.lab2.math.Function;
import se.ifmo.ru.s267880.softwareTesting.lab2.math.LogarithmMath;
import se.ifmo.ru.s267880.softwareTesting.lab2.math.TrigonometricMath;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class App {
    static class NamedFunction {
        public final String name;
        public final Function func;

        public NamedFunction(String name, Function func) {
            this.name = name;
            this.func = func;
        }
    }

    static final TrigonometricMath trigMath = TrigonometricMath.createWithSin(BasedFunctions.sin);
    static final LogarithmMath logMath = LogarithmMath.createWithLn(BasedFunctions.ln);

    static final NamedFunction[] functionsList = {
            new NamedFunction("sin", trigMath.sin),
            new NamedFunction("cos", trigMath.cos),
            new NamedFunction("sec", trigMath.sec),
            new NamedFunction("csc", trigMath.csc),
            new NamedFunction("tan", trigMath.tan),
            new NamedFunction("cot", trigMath.cot),
            new NamedFunction("ln", logMath.ln),
            new NamedFunction("log2", logMath.log2),
            new NamedFunction("System function (from the variant)", new SystemFunction(trigMath, logMath))
    };

    public static void main(String[] args) throws IOException  {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = System.out;
        out.println("Here are the list of functions:");
        for (int i = 0; i < functionsList.length; ++i) {
            out.printf("\t%d) %s\n", i, functionsList[i].name);
        }
        out.println("Enter the list of functions that you wanted to calculate\n(space-separated numbers, can be duplicate) (empty line for all functions above with respective order):");
        String line = inp.readLine();
        List<NamedFunction> pickedFuncList = (line.isEmpty()
                    ? IntStream.range(0, functionsList.length)
                    : Arrays.stream(line.split("\\s")).mapToInt(s -> Integer.parseInt(s.trim()))
                )
                .mapToObj(id -> functionsList[id])
                .collect(Collectors.toList());
        out.println("Enter the start value: ");
        double startX = Double.parseDouble(inp.readLine().trim());
        out.println("Enter the end value: ");
        double endX = Double.parseDouble(inp.readLine().trim());
        out.println("Enter the step:");
        double step = Double.parseDouble(inp.readLine().trim());
        out.println("Enter file name (default is `out.csv`): ");
        String fileName = inp.readLine();
        if (fileName.isEmpty()) {
            fileName = "out.csv";
        }

        try (PrintStream outFile = new PrintStream(new FileOutputStream(fileName))) {
            outFile.printf("x,%s\n", pickedFuncList.stream().map(f -> f.name).collect(Collectors.joining(",")));
            for (double x = startX; x <= endX; x += step) {
                final double curX = x;  // Java is too stupid that requires this to be effectively final
                outFile.printf("%.7f,%s\n", x, pickedFuncList.stream()
                        .mapToDouble(f -> {
                            try {
                                return f.func.calculate(curX);
                            } catch (IllegalArgumentException e) {
                                return Double.NaN;
                            }
                        })
                        .mapToObj(f -> String.format("%.7f", f))
                        .collect(Collectors.joining(",")));
            }
        }
    }
}
