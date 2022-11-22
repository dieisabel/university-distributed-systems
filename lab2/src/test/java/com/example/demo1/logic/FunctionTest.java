package com.example.demo1.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionTest {

    private Function function;
    private double eps = 10e-4;

    @BeforeEach
    void setUp() {
        function = new Function();
    }

    @Test
    void testCalculate() {
        double testValue1 = 1.4143;
        double testValue2 = 1.5652;
        double testValue3 = 1.7677;
        assertEquals(testValue1, function.calculate(1.0), eps);
        assertEquals(testValue2, function.calculate(2.5), eps);
        assertEquals(testValue3, function.calculate(4.0), eps);
    }
}
