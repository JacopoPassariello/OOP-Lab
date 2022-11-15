package it.unisa.railways;

import java.util.List;

public class ExpressTrain extends Train{

    private int numberOfRestaurantSeats;

    public ExpressTrain(TrainStop start, TrainStop end, List<TrainStop> middle, int numberOfSeats,int numberOfRestaurantSeats, int kilometresTraveled)
    {
        super(start,end,middle,numberOfSeats,kilometresTraveled);
        this.numberOfRestaurantSeats = numberOfRestaurantSeats;
    }

    public double computeMaxRevenues(double pricePerKilometre,double restaurantPrice ) {
        return super.computeMaxRevenues(pricePerKilometre)+numberOfRestaurantSeats*(restaurantPrice)*super.getKilometresTraveled();
    }
}
