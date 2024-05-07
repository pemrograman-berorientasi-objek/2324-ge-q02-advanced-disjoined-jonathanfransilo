package academic.model;

public class Record {
   

    private String code;
    private String name;
    private int credits;
    private String grade;
    private String lecturerInitial;

    public Record(String code, String name, int credits, String grade) {
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
        return lecturerInitial;
    }

    public void setLecturerInitial(String lecturerInitial) {
        // Menyimpan nilai inisial pengajar sebelum perubahan
        String previousInitial = this.lecturerInitial;
        
        // Mengatur inisial pengajar baru
        this.lecturerInitial = lecturerInitial;
        
        // Mencatat perubahan inisial pengajar ke dalam log
       
    }
}
