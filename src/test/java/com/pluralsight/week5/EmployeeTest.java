package com.pluralsight.week5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    Employee e;
    @BeforeEach
    void setUp() {
        e = new Employee();
    }

    @Test
    void punchIn_Positive() {
        e.punchIn(10.00);
        assertEquals(10.00, e.getStartTime());
    }

    @Test
    void punchIn_Negative() {
        e.punchIn(-10.00);
        assertEquals(-1, e.getStartTime());
    }

    @Test
    void punchOut() {
        e.punchIn(10.00);
        e.punchOut(12.00);
        assertEquals(2, e.getHoursWorked());
    }
}