package by.bsu.taxicompany.main;

import by.bsu.taxicompany.Serializable.Connector;
import by.bsu.taxicompany.carhierarchy.Car;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        TaxiStation station = new TaxiStation("src/main/resources/data/Cars.csv");

        List<Car> carPool = station.getCarPool();

        Connector connector = new Connector();
        connector.writeObject(carPool);

        List<Car> carPoolRead = connector.readObject();

        for (Car car : carPoolRead) {
            System.out.print(car);

            System.out.println();
        }

    }

}
