package com.pluralsight.week5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SimpleCalculatorTest {

    @Test
    void addTwoNumbers() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        double result = simpleCalculator.addTwoNumbers(2, 4);
        assertEquals(6, result);
    }

    @Test
    void addTwoNumbers_negativeNrs() {
        // arrange
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        // act
        double result = simpleCalculator.addTwoNumbers(-2, -4);
        // assert
        assertEquals(-6, result);

    }

    @Test
    void divideTwoNumbers() {
        // arrange
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        // act
        double result = simpleCalculator.divideTwoNumbers(4, 2);
        // assert
        assertEquals(2, result);
    }

    @Test
    void divideTwoNumbers_negativeNumbers() {
        // arrange
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        // act
        double result = simpleCalculator.divideTwoNumbers(-10, 5);
        // assert
        assertEquals(-2, result);
    }

    @Test
    void divideTwoNumbers_divisionByZero() {
        // arrange
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        // act
        // assert
        assertThrows(ArithmeticException.class,
                ()->{
                    simpleCalculator.divideTwoNumbers(10, 0);
                });
    }
}