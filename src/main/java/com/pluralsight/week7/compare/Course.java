package com.pluralsight.week7.compare;

public class Course implements Comparable<Course>{
    private String title;
    private int numOfPoint;
    private int maxStudent;

    public Course(String title, int numOfPoint, int maxStudent) {
        this.title = title;
        this.numOfPoint = numOfPoint;
        this.maxStudent = maxStudent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumOfPoint() {
        return numOfPoint;
    }

    public void setNumOfPoint(int numOfPoint) {
        this.numOfPoint = numOfPoint;
    }

    public int getMaxStudent() {
        return maxStudent;
    }

    public void setMaxStudent(int maxStudent) {
        this.maxStudent = maxStudent;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", numOfPoint=" + numOfPoint +
                ", maxStudent=" + maxStudent +
                '}';
    }

    @Override
    public int compareTo(Course o) {
        return o.numOfPoint - this.numOfPoint;
    }
}
