package com.pluralsight.week5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameFormatterTest {

    @Test
    void testFormat_TwoParameters() {
        assertEquals("Chau, Tam", NameFormatter.format("Tam", "Chau"));
    }

    @Test
    void testFormat_FourParameters() {
        assertEquals("Chau, Mr. Tam Van", NameFormatter.format("Mr.", "Tam", "Van", "Chau", ""));
    }

    @Test
    void testFormat_FullName() {
        assertEquals("Chau, Tam Van", NameFormatter.format("Tam Van Chau"));
    }
}