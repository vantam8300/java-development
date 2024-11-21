package com.pluralsight.week7.lamdaexpresions;

@FunctionalInterface
public interface Predicate<T> {
    boolean test (T obj);
}
