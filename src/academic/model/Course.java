package academic.model;

/**
 @author 12S22036 Jonathan Fransilo Hutabarat
         12S22030 Bryan Evans Simamora
 */
public class Course {
    private String code;
    private String name;
    private int credits;
    private String grade;
    private String lecturer_initial;

    public Course(String code, String name, int credits, String grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getGrade() {
        return grade;
    }

    public String getLecturerInitial() {
        return lecturer_initial;
    }

    public void setLecturerInitial(String lecturer_initial) {
        this.lecturer_initial = lecturer_initial;
    }
} 