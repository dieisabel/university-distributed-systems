package com.example.demo1.logic;

import java.util.function.DoubleUnaryOperator;

public class IntegralCalculator {

    private double a;
    private double b;
    private int n;
    private DoubleUnaryOperator f;

    private double totalResult;
    private int finishedThreadsCount;

    public IntegralCalculator(double a, double b, int n, DoubleUnaryOperator f) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.f = f;
        totalResult = (f.applyAsDouble(a) + f.applyAsDouble(b)) / 2 * ((b - a) / n);
        finishedThreadsCount = 0;
    }

    public double calculate(int threadsCount) {
        double delta = (b - a) / threadsCount;
        for (int i = 0; i < threadsCount; i++) {
            new Thread(createCalculationThread(a + i * delta, a + (i + 1) * delta, n / threadsCount, f)).start();
        }
        synchronized (this) {
            try {
                while (finishedThreadsCount < threadsCount) {
                    wait();
                }
            } catch (InterruptedException exception) {
                exception.printStackTrace();
                System.exit(-1);
            }
        }
        return totalResult;
    }

    private CalculationThread createCalculationThread(double a, double b, int n, DoubleUnaryOperator f) {
        return new CalculationThread(this, a, b, n, f);
    }

    public synchronized void sendResult(double result) {
        totalResult += result;
        finishedThreadsCount++;
        notify();
    }
}
