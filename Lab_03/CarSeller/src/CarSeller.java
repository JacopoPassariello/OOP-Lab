import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarSeller {
    private final List<Car> cars;

    public CarSeller() {
        this.cars = new ArrayList<>();
    }

    public void getCarsFromFile(File file) throws FileNotFoundException
    {
        Scanner in = new Scanner (file);
        int modelYear;
        double price;
        String brand;
        String model;

        while(in.hasNextLine())
        {
            brand = in.nextLine();
            model = in.nextLine();
            modelYear = Integer.parseInt(in.nextLine());
            price = Double.parseDouble(in.nextLine());
            Car temp = new Car(brand,model,modelYear,price);
            cars.add(temp);

        }

    }
    public boolean find(String brand,String model)
    {
        for(Car temp : cars)
        {
            if(temp.getBrand().equals(brand) && temp.getModel().equals(model))
                return true;
        }
        return false;
    }

    public boolean find(String brand,String model,int modelYear)
    {
        for(Car temp : cars)
        {
            if(temp.getBrand().equals(brand) && temp.getModel().equals(model) && temp.getManufacturingYear() >= modelYear)
                return true;
        }
        return false;
    }

    public boolean find(String brand,String model,double lowerBound,double upperBound)
    {
        if(upperBound < lowerBound) return false;
        for(Car temp : cars)
        {
            if(temp.getBrand().equals(brand) && temp.getModel().equals(model) && temp.getPrice() >= lowerBound && temp.getPrice() <= upperBound)
                return true;
        }
        return false;
    }

}


