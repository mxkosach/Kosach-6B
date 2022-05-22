package by.bsu.taxicompany.Serializable;

import by.bsu.taxicompany.carhierarchy.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Connector {
    public void writeObject(List<Car> carPool) throws IOException {
        try {


            FileOutputStream fos = new FileOutputStream("src/main/resources/data/cars.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Car car : carPool) {
                oos.writeObject(car);
            }
            oos.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Car> readObject() throws IOException {
        List<Car> carPool = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/data/cars.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                Car car = (Car) ois.readObject();
                carPool.add(car);
            }


            ois.close();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return carPool;
    }
}