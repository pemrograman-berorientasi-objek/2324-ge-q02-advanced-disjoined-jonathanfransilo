package academic.driver;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 @author 12S22036 Jonathan Fransilo Hutabarat
         12S22030 Bryan Evans Simamora 
 */
import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Lecturer;
import academic.model.Student;
import academic.model.Person;
import academic.model.CourseOpening;

class Driver1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        ArrayList<Lecturer> lecturers = new ArrayList<>();
        ArrayList<CourseOpening> courseOpenings = new ArrayList<>();

        
        while ( scanner.hasNextLine()) {

            String input = scanner.nextLine().trim();
            if (input.equals("---")) {
                break;
            }

            String[] proses = input.split("#");
            String command = proses[0];

            switch (command) {
                case "course-add":
                    String Code = proses[1];
                    String Name = proses[2];
                    int Credits = Integer.parseInt(proses[3]);
                    String Grade = proses[4];
                    // String[] lecturerInitialList = proses[5].split(",");

                    // StringBuilder lecturerInfo = new StringBuilder();
                    // for (String lecturerInitial : lecturerInitialList) {
                    //     // Find lecturer by initial
                    //     Lecturer lecturerFound = lecturers.stream()
                    //             .filter(l -> l.getInitial().equals(lecturerInitial))
                    //             .findFirst()
                    //             .orElse(null);
                    //     if (lecturerFound != null) {
                    //         if (lecturerInfo.length() > 0) {
                    //             lecturerInfo.append(";");
                    //         }
                    //         lecturerInfo.append(lecturerInitial)
                    //                 .append(" (")
                    //                 .append(lecturerFound.getEmail())
                    //                 .append(")");
                    //     }
                    // }

                    Course course = new Course(Code, Name, Credits, Grade);
                    // course.setLecturerInitial(lecturerInfo.toString());
                    courses.add(course);
                    break;
                case "course-open":
                    String CodeCode = proses[1];
                    String academicyear = proses[2];
                    String even = proses[3];
                    String[] lecturerInitialList = proses[4].split(",");
                        StringBuilder lecturerInfo = new StringBuilder();
                        for (String lecturerInitial : lecturerInitialList) {
                            // Find lecturer by initial
                            Lecturer lecturerFound = lecturers.stream()
                                    .filter(l -> l.getInitial().equals(lecturerInitial))
                                    .findFirst()
                                    .orElse(null);
                            if (lecturerFound != null) {
                                if (lecturerInfo.length() > 0) {
                                    lecturerInfo.append(";");
                                }
                                lecturerInfo.append(lecturerInitial)
                                        .append(" (")
                                        .append(lecturerFound.getEmail())
                                        .append(")");
                            }
                        }
                    boolean haslecturer = false;
                    for (Lecturer lec : lecturers) {
                        if (lec.getInitial().equals(lecturerInitialList)) {
                            haslecturer = true;
                            break;
                        }
                    }

                    for (Course courseOpen : courses) {
                        if (courseOpen.getCode().equals(CodeCode)){
                            haslecturer = true;
                        }
                        
                        if (haslecturer) {
                            CourseOpening courseOpening = new CourseOpening(CodeCode, academicyear, even, lecturerInfo.toString());
                            courseOpenings.add(courseOpening);
                        }
                    }
                        break;
                case "course-history":
                courseOpenings.sort((co1, co2) -> co2.getSemester().compareTo(co1.getSemester()));
                    for (CourseOpening courseOpening : courseOpenings) {
                        String matakuliah = "";
                        String sks = "";
                        String grade = "";

                        for (Course courseopen : courses) {
                            if (courseOpening.getCourseCode().equals(courseopen.getCode())) {
                                matakuliah = courseopen.getName();
                                sks = String.valueOf(courseopen.getCredits());
                                grade = courseopen.getGrade();
                            }
                            System.out.println(courseOpening.getCourseCode() + "|" + matakuliah + "|" + sks + "|" + grade + "|" + courseOpening.getAcademicYear() + "|" + courseOpening.getSemester() + "|" + courseOpening.getLecturerInitial());
                        } for (Enrollment enrollment : enrollments) {
                            if (enrollment.getCourseCode().equals(courseOpening.getCourseCode()) && enrollment.getAcademicYear().equals(courseOpening.getAcademicYear()) && enrollment.getSemester().equals(courseOpening.getSemester())) {
                                if(!enrollment.getChange().equals("")){
                                    System.out.println(enrollment.getCourseCode() + "|" + enrollment.getStudentId() + "|"
                                            + enrollment.getAcademicYear() + "|" + enrollment.getSemester() + "|" +enrollment.getGrade() + "("
                                            + enrollment.getChange()+")");
                                } else {
                                    System.out.println(enrollment.getCourseCode() + "|" + enrollment.getStudentId() + "|"
                                            + enrollment.getAcademicYear() + "|" + enrollment.getSemester() + "|" + enrollment.getGrade());
                                }
                            }
                        }
                        
                    }
                        break;
                case "lecturer-add":
                    String Id = proses[1];
                    String lecturerName = proses[2];
                    String Initial = proses[3];
                    String Email = proses[4];
                    String StudyProgram = proses[5];

                    // Check for duplicate lecturer email
                    boolean isDuplicateEmail = false;
                    for (Person person : lecturers) {
                        if (person instanceof Lecturer) { // Periksa apakah objek merupakan instance dari Lecturer
                            Lecturer lecturer = (Lecturer) person; // Cast objek menjadi Lecturer
                            if (lecturer.getEmail().equals(Email)) {
                                isDuplicateEmail = true;
                                break;
                            }
                        }
                    }

                    if (!isDuplicateEmail) {
                        Lecturer newLecturer = new Lecturer(Id, lecturerName, Email,
                                StudyProgram, Initial);
                        lecturers.add(newLecturer);
                    }
                    break;

                case "enrollment-add":
                    String enrollmentCourseCode = proses[1];
                    String enrollmentStudentId = proses[2];
                    String enrollmentAcademicYear = proses[3];
                    String enrollmentSemester = proses[4];
                    String enrollmentGrade = "None";

                    Enrollment enrollment = new Enrollment(enrollmentCourseCode, enrollmentStudentId,
                            enrollmentAcademicYear, enrollmentSemester, enrollmentGrade);
                    enrollments.add(enrollment);
                    break;

                case "student-add":
                    String studentId = proses[1];
                    String studentName = proses[2];
                    int studentYear = Integer.parseInt(proses[3]);
                    String studentMajor = proses[4];

                    // Check for duplicate student ID
                    boolean isDuplicateId = students.stream().anyMatch(s -> s.getId().equals(studentId));
                    if (!isDuplicateId) {
                        Student newStudent = new Student(studentId, studentName, studentYear, studentMajor);
                        students.add(newStudent);
                    }
                    break;

                case "enrollment-grade":
                    String gradeCourseCode = proses[1];
                    String gradeStudentId = proses[2];
                    String academicYear = proses[3];
                    String semester = proses[4];
                    String grade = proses[5];

                    // Find enrollment
                    Enrollment foundEnrollment = enrollments.stream()
                            .filter(e -> e.getCourseCode().equals(gradeCourseCode)
                                    && e.getStudentId().equals(gradeStudentId)
                                    && e.getAcademicYear().equals(academicYear)
                                    && e.getSemester().equals(semester)
                                    && e.getGrade().equals("None"))
                            .findFirst()
                            .orElse(null);
                    if (foundEnrollment != null) {
                        foundEnrollment.setGrade(grade);
                    }
                    break;
                
                case "student-details":
                    String studentIdDetails = proses[1];
                    int totalCredits = 0;
                    double totalGrade = 0;
                    Map<String, Double> CreditsByCourseCode = new HashMap<>();
                    
                    for (Enrollment enrollmentDetails : enrollments) {
                        if (enrollmentDetails.getStudentId().equals(studentIdDetails)&& !enrollmentDetails.getGrade().equals("None")) {
                            int credits = getCreditsByCourseCode(courses, enrollmentDetails.getCourseCode());
                            double grades = kalkulasiGrade(enrollmentDetails.getGrade()) * credits;

                            if (CreditsByCourseCode.containsKey(enrollmentDetails.getCourseCode())) {
                                if (CreditsByCourseCode.get(enrollmentDetails.getCourseCode()) < grades) {
                                    totalCredits -= credits ;
                                    totalGrade -= CreditsByCourseCode.get(enrollmentDetails.getCourseCode());
                                    CreditsByCourseCode.put(enrollmentDetails.getCourseCode(), grades);
                                }
                            } else {
                                CreditsByCourseCode.put(enrollmentDetails.getCourseCode(), grades);
                            }
                            totalCredits += credits;
                            totalGrade += grades;

                        }
                    }
                    double gpa = totalGrade / totalCredits;

                    for(Student student : students){
                        if(student.getId().equals(studentIdDetails)){
                            System.out.println(student.getId() + "|" + student.getName() + "|" + student.getYear() + "|" + student.getMajor() + "|" + String.format("%.2f", gpa)+"|"+ totalCredits);
                        }
                    }
                    break;

                case "enrollment-remedial":
                    for (Enrollment enr : enrollments) {
                        if (enr.getCourseCode().equals(proses[1]) 
                            && enr.getStudentId().equals(proses[2]) 
                            && enr.getAcademicYear().equals(proses[3]) 
                            && enr.getSemester().equals(proses[4])){
                            if(enr.getGrade().equals("None")){
                                break;
                            } else {
                                if(enr.getTotalRemedial() == 0){
                                    enr.setChange(proses[5]);
                                    enr.tukargarde();
                                    enr.setTotalRemedial();
                                } else {
                                    String change = enr.getChange();
                                    enr.setChange(change );
                                }
                                break;
                            }
                        }
                    }
            }
        }

        // Print lecturers
        for (Lecturer lecturer : lecturers) {
            System.out.println(lecturer.getId() + "|" + lecturer.getName() + "|" + lecturer.getInitial() + "|"
                    + lecturer.getEmail() + "|" + lecturer.getStudyProgram());
        }

        // Print courses
        for (Course course : courses) {
            System.out.println(course.getCode() + "|" + course.getName() + "|" + course.getCredits() + "|"
                    + course.getGrade() /*+ "|" + course.getLecturerInitial()*/);
        }

        // Print students
        for (Student student : students) {
            System.out.println(student.getId() + "|" + student.getName() + "|" + student.getYear() + "|"
                    + student.getMajor());
        }

        // Print enrollments
        for (Enrollment enrollment : enrollments) {
            if(!enrollment.getChange().equals("")){
                System.out.println(enrollment.getCourseCode() + "|" + enrollment.getStudentId() + "|"
                        + enrollment.getAcademicYear() + "|" + enrollment.getSemester() + "|" +enrollment.getGrade() + "("
                        + enrollment.getChange()+")");
            } else {
                System.out.println(enrollment.getCourseCode() + "|" + enrollment.getStudentId() + "|"
                        + enrollment.getAcademicYear() + "|" + enrollment.getSemester() + "|" + enrollment.getGrade());
            }
        }

        scanner.close();
    }

    private static double kalkulasiGrade(String grade) {
        String gradeWithoutParentheses = grade.contains("(") ? grade.substring(0, grade.indexOf("(")) : grade;
        switch (gradeWithoutParentheses) {
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
            case "E":
                return 0.0;
            default:
                return 0.0;
        }
    }

    // private static Lecturer findLecturerByInitial(List<Lecturer> lecturers, String initial){
    //     for (Lecturer lecturer : lecturers) {
    //         if (lecturer.getInitial().equals(initial)) {
    //             return lecturer;
    //         }
    //     }
    //     return null;
    // }

    private static int getCreditsByCourseCode(List<Course> courses, String code){
        for (Course course : courses) {
            if (course.getCode().equals(code)) {
                return course.getCredits();
            }
        }
        return 0;
    }
}