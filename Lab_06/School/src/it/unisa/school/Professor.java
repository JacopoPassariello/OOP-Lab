package it.unisa.school;

import java.util.GregorianCalendar;

public class Professor extends Person {

    private final String topic;

    private double wage;

    public Professor(String name, String surname, int birthYear, String specialization, double wage){
        super(name,surname,birthYear);
        this.topic = specialization;
        this.wage = wage;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Argomento='" + topic + '\'' +
                ", Stipendio=" + wage;
    }

    public String getTopic() {
        return topic;
    }

    public double getWage() {
        return wage;
    }
}