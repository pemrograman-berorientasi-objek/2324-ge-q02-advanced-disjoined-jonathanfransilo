package academic.model;

public class CourseOpening {
    private String CourseCode;
    private String AcademicYear;
    private String Semester;
    private String LecturerInitial;

    public CourseOpening(String CourseCode, String AcademicYear, String Semester, String LecturerInitial) {
        this.CourseCode = CourseCode;
        this.AcademicYear = AcademicYear;
        this.Semester = Semester;
        this.LecturerInitial = LecturerInitial;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public String getAcademicYear() {
        return AcademicYear;
    }

    public String getSemester() {
        return Semester;
    }

    public String getLecturerInitial() {
        return LecturerInitial;
    }
    
    
}