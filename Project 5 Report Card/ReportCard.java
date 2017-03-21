package com.example.android.miwok;

/**
 * Created by Muhammad Attia on 25/02/2017.
 */

public class ReportCard {
    private int studentId;
    private String studentName;
    private String studentLevel;

    public ReportCard(int stuId, String stuName, String level) {
        this.studentId = stuId;
        this.studentName = stuName;
        this.studentLevel = level;
    }

    public int getstuId() {
        return studentId;
    }

    public void setstuId(int id) {
        studentId = id;
    }

    public String getstuName() {
        return studentName;
    }

    public void setstuName(String name) {
        studentName = name;
    }


    public String getlevel() {
        return studentLevel;
    }

    public void setlevel(String level) {
        this.studentLevel = level;
    }

    @Override
    public String toString() {
        return "ReportCard{" +
                "student Id = " + studentId +
                "\n student Name = " + studentName +
                "\n level = " + studentLevel;
    }
}
