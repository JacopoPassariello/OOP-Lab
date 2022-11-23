package it.unisa.railways;

import java.util.ArrayList;
import java.util.List;

public class Train {

    List <TrainStop> middleStops;
    TrainStop start;
    TrainStop end;
    private int numberOfAvailableSeats;
    private int kilometresTraveled;
    private int numberOfStops;

    public Train(TrainStop start, TrainStop end, List<TrainStop> middle, int numberOfSeats, int kilometresTraveled)
    {
        this.numberOfAvailableSeats = numberOfSeats;
        this.end = end;
        this.start = start;
        middleStops = middle;
        this.numberOfStops = 2 + middle.size();
        this.kilometresTraveled = kilometresTraveled;
    }

    public int getTotalNumberOfStops()
    {
        return this.numberOfStops;
    }

    public double computeMaxRevenues(double pricePerKilometre)
    {
        return (this.numberOfAvailableSeats*kilometresTraveled*pricePerKilometre);
    }

    public int getKilometresTraveled() {
        return kilometresTraveled;
    }
}