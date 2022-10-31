package it.unisa.student;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class StudentTest {
    @Test
    public void newStudentTest() {
        Student student = new Student("Dario", "Di Nucci");
        Assert.assertEquals("Dario", student.getFirstName());
        Assert.assertEquals("Di Nucci", student.getLastName());
        Assert.assertTrue(student.getExams().isEmpty());
    }

    @Test
    public void oneExamTest() {
        Student student = new Student("Dario", "Di Nucci");

        Exam exam = new Exam("Object Oriented Programming", new GregorianCalendar(2023, Calendar.JANUARY, 10), 30);
        student.registerExam(exam);

        Assert.assertEquals(1, student.getExams().size(), 0);
        Assert.assertEquals(30, student.computeAverageGrade(), 0);
    }

    @Test
    public void twoExamTest() {
        Student student = new Student("Dario", "Di Nucci");

        Exam exam1 = new Exam("Object Oriented Programming", new GregorianCalendar(2023, Calendar.JANUARY, 10), 30);
        student.registerExam(exam1);

        Exam exam2 = new Exam("Software Engineering", new GregorianCalendar(2024, Calendar.JANUARY, 20), 28);
        student.registerExam(exam2);

        Assert.assertEquals(2, student.getExams().size(), 0);
        Assert.assertEquals(29, student.computeAverageGrade(), 0);
    }

    @Test
    public void studentsOrderTest() {
        List<Student> s = new ArrayList<>();
        s.add(new Student("Tony","Loaf"));
        s.add(new Student("Claudio","Gaudente"));
        s.add(new Student("Hans","Strudel"));
        s.add(new Student("Vladimir","Vodka"));
        s.add(new Student("Presidentedellarepubblica","Sergiomattarella"));

        Student maximum = s.get(0);
        Student minimum = s.get(0);
        for(Student temp : s)
        {
            if(temp.compareTo(maximum) > 0) maximum = temp;
            if(temp.compareTo(minimum) < 0) minimum = temp;
        }
        Assert.assertEquals("Gaudente",minimum.getLastName());
        Assert.assertEquals("Vodka",maximum.getLastName());
    }
}