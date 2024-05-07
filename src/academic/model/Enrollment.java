package academic.model;
/**
 @author 12S22036 Jonathan Fransilo Hutabarat
         12S22030 Bryan Evans Simamora
 */
public class Enrollment {
    private String courseCode;
    private String studentId;
    private String academicYear;
    private String semester;
    private String grade;
    private String change;
    private String remedial;
    private int totalremedial;


    public Enrollment(String courseCode, String studentId, String academicYear, String semester, String grade) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None";
        this.change = "";
        this.remedial = null;
        this.totalremedial = 0;
        
    }

    public String getCourseCode() {
        return courseCode;
    } 

    public String getStudentId() {
        return studentId;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getChange() {
        return change;
    }
    
    public void setChange(String change) {
        this.change = change;
    }

    public String getRemedial() {
        return remedial;
    }

    public void setRemedial(String remedial) {
        this.remedial = remedial;
    }

    public int getTotalRemedial() {
        return totalremedial;
    }

    public void setTotalRemedial() {
        this.totalremedial += 1;
    }

    public void tukargarde() {
        String temp = "";
        temp = this.grade;
        this.grade = this.change;
        this.change = temp;
    }

}