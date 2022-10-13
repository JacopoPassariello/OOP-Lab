import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class StudentTest {
    @Test public void ExamTest()
    {
        Student prova = new Student("Joe", "Mama");

        GregorianCalendar dataEsami = new GregorianCalendar(2022,Calendar.DECEMBER,12);

        Exam esame1 = new Exam("Sistemi Operativi",dataEsami,18);
        Exam esame2 = new Exam("Programmazione Object Oriented", dataEsami, 30);
        Exam esame3 = new Exam("Basi di Dati", dataEsami, 25);

        prova.registerExam(esame1);
        prova.registerExam(esame2);
        prova.registerExam(esame3);

        Assert.assertEquals((double)(30+25+18)/3,prova.computeAverageGrade(),0);
    }
}