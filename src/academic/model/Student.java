package academic.model;

import java.util.ArrayList;
import java.util.List;

/**
 @author 12S22036 Jonathan Fransilo Hutabarat
         12S22030 Bryan Evans Simamora
 */

public class Student extends Person {
    private int year;
    private String major;

    public Student(String id, String name, int year, String major) {
        super(id, name); // Memanggil konstruktor superclass
        this.year = year;
        this.major = major;
    }

    public int getYear() {
        return year;
    }

    public String getMajor() {
        return major;
    }
    // Method to convert grade to GPA
    public static double gradeToIPK(String grade) {
        switch (grade) {
            case "A":
                return 4.0;
            case "AB":
                return 3.5;
            case "B":
                return 3.0;
            case "BC":
                return 2.5;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            default:
                return 0.0;
        }
    }
}