package it.unisa.medicaltests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

public class MedicalTestList {

    private final List<MedicalTest> medicalTestList;

    public MedicalTestList() {
        this.medicalTestList = new ArrayList<>();
    }

    public void addMedicalTest(MedicalTest mt) {
        medicalTestList.add(mt);
    }

    public List<MedicalTest> getMedicalTestByDate(GregorianCalendar date) {
        List<MedicalTest> byDate = new ArrayList<>();
        for(MedicalTest e : medicalTestList)
        {
            if(date.equals(e.getDate())) byDate.add(e);
        }
        return byDate;
    }

    public List<MedicalTest> getMedicalTestByDoctor(String doctorName) {
        List<MedicalTest> byDoctor = new ArrayList<>();
        for(MedicalTest e : medicalTestList)
        {
            if(doctorName.equals(e.getDoctorName())) byDoctor.add(e);
        }
        return byDoctor;
    }

    public double getAverageCost() {
        double averageCost = 0;
        for(MedicalTest e : medicalTestList)
        {
            averageCost += e.getCost();
        }
        return (averageCost/medicalTestList.size());
    }

    public List<MedicalTest> getMedicalTestList() {
        return medicalTestList;
    }
}
