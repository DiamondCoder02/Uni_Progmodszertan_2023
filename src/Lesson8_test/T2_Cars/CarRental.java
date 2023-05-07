package Lesson8_test.T2_Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;

class CarRental {
    List<Car> cars = new ArrayList<>();

    public static List<Car> listAllCars(List<Car> cars) {
        out.println("----------------------------listAllCars method----------------------------");
        if (cars.isEmpty()) {
            out.println("----- No cars found! -----");
            return cars;
        }
        for (Car car : cars) {
            out.println("Id: " + car.getId());
            out.println("Brand: " + car.getBrand());
            out.println("Year: " + car.getYear());
            out.println("Color: " + car.getColor());
            out.println("----------------------------");
        }
        return cars;
    }

    public static List<Car> removeCar(List<Car> cars, Scanner input) {
        out.println("----------------------------removeCar method----------------------------");
        out.println("Please enter the id of the car you want to remove: ");
        int id = input.nextInt();
        for (Car car : cars) {
            if (car.getId() == id) {
                cars.remove(car);
                out.println("----- Car removed! -----");
                input.close();
                return cars;
            }
        }
        out.println("----- Car not found! -----");
        // Lazy to fix resource leak for Scanner... One day...
        return cars;
    }

    public static List<Car> addCar(List<Car> cars, Scanner input) {
        out.println("----------------------------addCar method----------------------------");
        // Must get an id so every car has a unique id
        out.println("Please enter the id of the car: ");
        int id = input.nextInt();
        out.println("Please enter the brand of the car: ");
        String brand = input.next();
        out.println("Please enter the year of the car: ");
        int year = input.nextInt();
        out.println("Please enter the color of the car: ");
        String color = input.next();
        Car car = new Car(id, brand, year, color);
        cars.add(car);
        out.println("----- Car added! -----");
        // Yup, still leaking resources
        return cars;
    }
}
