import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String firstName;
    private final String lastName;
    List<Exam> exams;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        exams = new ArrayList<Exam>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void registerExam(Exam exam) {
        exams.add(exam);
    }

    public double computeAverageGrade() {
        double totalGrades = 0;
        for(Exam temp : exams)
        {
            totalGrades+=temp.getGrade();

        }
        return totalGrades/exams.size();
    }
}