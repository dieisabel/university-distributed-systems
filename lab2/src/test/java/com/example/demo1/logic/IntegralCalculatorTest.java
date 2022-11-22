package com.example.demo1.logic;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class IntegralCalculatorTest {

    private IntegralCalculator calculator;
    private double eps = 10e-3;

    @BeforeEach
    void setUp() {
        calculator = new IntegralCalculator(1.0, 4.0, 100_000_000, new Function()::calculate);
    }

    @org.junit.jupiter.api.Test
    void testCalculate() {
        double testValue = 4.7140;
        assertEquals(testValue, calculator.calculate(1), eps);
    }
}
