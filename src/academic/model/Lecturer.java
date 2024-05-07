package academic.model;
/**
 @author 12S22036 Jonathan Fransilo Hutabarat
         12S22030 Bryan Evans Simamora 
 */
public class Lecturer extends Person {
    private String email;
    private String studyProgram;
    private String initial;

    public Lecturer(String id, String name, String email, String studyProgram, String initial) {
        super(id, name); // Memanggil konstruktor superclass
        this.email = email; // Menyimpan email
        this.studyProgram = studyProgram;
        this.initial = initial;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    public String getEmail() {
        return email;
    }
    public String getInitial() {
        return initial;
    }
}