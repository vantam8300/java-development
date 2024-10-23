package com.pluralsight.week5;

import java.time.LocalTime;

public class Employee {
    private String id;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    private double startTime = -1;
    private double endTime;

    public double getStartTime() {
        return startTime;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getTotalPay() {
        return getOvertimeHours() + getRegularHours();
    }

    public double getRegularHours() {
        return hoursWorked <= 40 ? payRate * hoursWorked : payRate * 40;
    }

    public double getOvertimeHours() {
        return hoursWorked > 40 ? (hoursWorked - 40) * payRate * 1.5 : 0;
    }

    public void punchIn(double time) {
        if (time > 0) {
            startTime = time;
        }
    }

    public void punchOut(double time) {
        endTime = time;
        hoursWorked += endTime - startTime;
        startTime = -1;

    }

    public void punchIn() {
        LocalTime now = LocalTime.now();
        double hours = now.getHour();
        double minute = now.getMinute();
        startTime = hours + (minute / 100);
    }

    public void punchOut() {
        LocalTime now = LocalTime.now();
        double hours = now.getHour();
        double minute = now.getMinute();
        endTime = hours + (minute / 100);
        startTime = -1;
        hoursWorked += endTime - startTime;
    }

    public void punchTimeCard(double time) {
        if (startTime == -1 ) {
            startTime = time;
        } else {
            endTime = time;
            double hours = endTime - startTime;
            hoursWorked += hours;
            startTime = -1;
        }
    }
}
