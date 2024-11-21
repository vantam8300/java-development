package com.pluralsight.week7.lamdaexpresions;

import java.util.function.Consumer;

public class LambdaExample {
    public static void main(String[] args) {
        NumericOperator sum = (num1, num2) -> num1 + num2;
        NumericOperator max = (num1, num2) -> Math.max(num1, num2);

        StringFormatter UpperCase = str -> str.toUpperCase();

        UnaryOperator unary = num -> (int) Math.pow(num, 2);
        TriFunction triFunction = (num1, num2, num3) -> (num1 + num2 + num3) / 3;

        System.out.println(unary.apply(2));
        System.out.println(triFunction.apply(2, 3, 4));

        Predicate<String> predicate = str -> str.isEmpty();

        System.out.println(predicate.test("avc"));

    }
}
