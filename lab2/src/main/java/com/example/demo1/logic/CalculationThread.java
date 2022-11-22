package com.example.demo1.logic;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.IntStream;

public class CalculationThread implements Runnable {

    private IntegralCalculator calculator;
    private double a;
    private double b;
    private int n;
    private DoubleUnaryOperator f;

    public CalculationThread(IntegralCalculator calculator, double a, double b, int n, DoubleUnaryOperator f) {
        this.calculator = calculator;
        this.a = a;
        this.b = b;
        this.n = n;
        this.f = f;
    }

    @Override
    public void run() {
        double result = calculate();
        calculator.sendResult(result);
    }

    public double calculate() {
        double step = (b - a) / n;
        return IntStream.range(1, n - 1).mapToDouble(i -> a + i * step).map(f).sum() * step;
    }
}
