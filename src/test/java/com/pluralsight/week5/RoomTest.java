package com.pluralsight.week5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    private Room room;


    @BeforeEach
    public void setUp() {
        // Create a new room object for testing before each test case
        room = new Room(2, 150.0, false, false);
    }

    @Test
    void checkIn() {
        // Check in should set isOccupied to true and isDirty to true
        room.checkIn();
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    void checkOut() {
        // Check out should set isOccupied to false
        room.checkIn(); // First check in the room
        room.checkOut();
        assertFalse(room.isOccupied());
    }

    @Test
    void cleanRoom() {
        // Cleaning the room should set isDirty to false
        room.setDirty(true);  // Mark as dirty
        room.cleanRoom();     // Now clean it
        assertFalse(room.isDirty());
    }

    @Test
    public void testIsAvailable() {
        // Initially, the room should be available because it's not dirty or occupied
        assertTrue(room.isAvailable());

        // Occupy the room; it should no longer be available
        room.setOccupied(true);
        assertFalse(room.isAvailable());

        // Set the room as dirty; it should still not be available
        room.setOccupied(false);  // Unoccupy the room
        room.setDirty(true);  // Mark as dirty
        assertFalse(room.isAvailable());

        // Clean the room; now it should be available
        room.cleanRoom();
        assertTrue(room.isAvailable());
    }
}