package it.unisa.school;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Hashtable;

public class Student extends Person {

    private String studentID;
    private int numberOfAbsences;

    private int averageGrade = 0;
    private Hashtable<String,Integer> passedExams;

    public Student(String name, String surname, int birthYear,String userID, String password, String studentID, int numberOfAbsences) {
        super(name, surname, birthYear,userID,password);
        if(studentID == null || studentID.isEmpty()) throw new IllegalArgumentException("La matricola è vuota.");
        this.numberOfAbsences = numberOfAbsences;
        this.studentID = studentID;
        this.passedExams= new Hashtable<>();
    }

    public String getStudentID()
    {
        return this.studentID;
    }

    public void addAbsence() {
        this.numberOfAbsences++;
    }

    public void removeAbsence() {
        this.numberOfAbsences--;
    }

    public int getNumberOfAbsences() {
        return numberOfAbsences;
    }

    public void addExam(String examName, int grade) {
        if(grade < 18 || grade > 31) throw new IllegalArgumentException("Formattazione errata");
        else
            passedExams.put(examName,grade);
            if(grade == 31) averageGrade += grade-1;
            else averageGrade += grade;
    }

    public int getNumberOfPassedExams() {
        return passedExams.size();
    }

    public double getAverageGrade() {
        return averageGrade/passedExams.size();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Numero di assenze=" + numberOfAbsences;
    }
}
