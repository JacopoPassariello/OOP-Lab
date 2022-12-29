package it.unisa.carseller;

import javax.swing.*;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.*;

public class CarSeller {
    private List<Car> cars;

    public CarSeller() {
        this.cars = new ArrayList<>();
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        this.cars = new ArrayList<>();
        while(in.hasNextLine()) {
            try
            {
                String brand = in.nextLine();
                String model = in.nextLine();
                int modelYear = Integer.parseInt(in.nextLine());
                double price = Double.parseDouble(in.nextLine());

                Car c = new Car(brand,model,modelYear,price);
                cars.add(c);
            }
            catch (NoSuchElementException | NumberFormatException e)
            {
                System.out.println("Errore di formattazione file!");
            }
        }
    }

    public void writeUserDataToFile(File file, boolean overwrite)throws FileNotFoundException,FileAlreadyExistsException {
        if(!overwrite && file.exists()) throw new FileAlreadyExistsException("Il file già esiste!");
        else
        {
                writeUserDataToFile(file);
        }
        if(overwrite && !file.exists())
        {
            throw new FileNotFoundException("Il file da sovrascrivere non esiste!");
        }
        else
        {
            String temp = file.getParentFile().getName() + File.separator + "tmp_" + file.getName();
            File tmpFile = new File(temp);
            writeUserDataToFile(tmpFile);
            file.delete();
            tmpFile.renameTo(file);

        }
    }

    public void writeUserDataToFile(File file) throws FileNotFoundException
    {
        PrintWriter out = new PrintWriter(file);
        for(Car car: this.cars)
        {
            out.println(car.getBrand());
            out.println(car.getModel());
            out.println(car.getManufacturingYear());
            out.println(car.getPrice());
        }
        out.close();
    }

    @SuppressWarnings("unchecked")
    public void readSerializedDataFromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        this.cars = (List<Car>) in.readObject();
        in.close();
    }

    public void writeSerializedDataToFile(File file) throws IOException
    {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(this.cars);
        out.close();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> returnCarByBrandAndModel(String brand, String model) {
        List<Car> suitableCars = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getBrand().equals(brand) && car.getModel().equals(model)) {
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }

    public List<Car> returnCarByBrandModelAndYear(String brand, String model, int manufacturingYear) {
        List<Car> suitableCars = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getBrand().equals(brand)
                    && car.getModel().equals(model)
                    && car.getManufacturingYear() >= manufacturingYear) {
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }

    public List<Car> returnCarByBrandAModelYearAndPrice(String brand, String model, int manufacturingYear, int minPrice, int maxPrice) {
        List<Car> suitableCars = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getBrand().equals(brand)
                    && car.getModel().equals(model)
                    && car.getManufacturingYear() >= manufacturingYear
                    && car.getPrice() >= minPrice
                    && car.getPrice() <= maxPrice) {
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }
}