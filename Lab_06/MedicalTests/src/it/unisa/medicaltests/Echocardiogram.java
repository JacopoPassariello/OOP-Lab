package it.unisa.medicaltests;

public class Echocardiogram extends MedicalTest {

    public enum Variants {
        SIMPLE,
        WITH_CONTRAST,
        STRESS
    }

    private final Variants type;
    private final int patientAge;

    public Echocardiogram(String doctorName, Variants type, int patientAge) {
        super(doctorName);
        this.patientAge = patientAge;
        this.type = type;
        if(type == Variants.WITH_CONTRAST) this.setCost((patientAge < 65) ? 45 : 45 * 0.8f);
        else this.setCost((patientAge < 65) ? 30 : 30 * 0.8f);
    }

    public Variants getType() {
        return type;
    }

    public int getPatientAge() {
        return patientAge;
    }

    @Override
    public String toString() {
        return "Echocardiogram{" +
                "doctorName='" + this.getDoctorName() + '\'' +
                ", cost=" + this.getCost() +
                ", report='" + this.getReport() + '\'' +
                ", date=" + this.getDate() +
                ", type=" + type +
                ", patientAge=" + patientAge +
                '}';
    }
}
