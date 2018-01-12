package com.example.shivamgupta.attendancemanager;

import java.io.Serializable;

/**
 * Created by Shivam Gupta on 09-01-2018.
 */

public class subjects implements Serializable {
    String subjectName;
    Float percentage;
    float totalClasses = 0;
    float bunkedClasses = 0;


    public subjects(String subjectName, Float percentage, float totalClasses, float bunkedClasses) {
        this.subjectName = subjectName;
        this.percentage = percentage;
        this.totalClasses = totalClasses;
        this.bunkedClasses = bunkedClasses;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Float getPercentage() {
        return percentage;
    }

    public float getTotalClasses() {
        return totalClasses;
    }

    public float getBunkedClasses() {
        return bunkedClasses;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public void setTotalClasses(float totalClasses) {
        this.totalClasses = totalClasses;
    }

    public void setBunkedClasses(float bunkedClasses) {
        this.bunkedClasses = bunkedClasses;
    }
}