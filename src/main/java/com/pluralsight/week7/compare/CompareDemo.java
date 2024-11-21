package com.pluralsight.week7.compare;

import java.util.List;

public class CompareDemo {
    public static void main(String[] args) {
        Course c1 = new Course("course 1", 10, 10);
        Course c2 = new Course("course 6", 100, 200);
        Course c3 = new Course("course 3", 3, 30);

        List<Course> courses = List.of(c1, c2, c3);
        courses.stream().sorted().forEach(c -> System.out.println(c));

    }
}
