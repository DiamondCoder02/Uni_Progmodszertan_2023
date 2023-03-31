package Lesson8_test.T2_Cars;

import java.util.Scanner;
import static java.lang.System.out;

public class CarMain {
    public static void main(String[] args) {
        CarRental carRental = new CarRental();
        // choose an option
        // 1. add a car
        // 2. remove a car
        // 3. list all cars
        // 4. exit
        Scanner input = new Scanner(System.in);
        int option = 0;
        while (option != 4) {
            out.println("----------------------------while cycle----------------------------");
            out.println("Please choose an option: ");
            out.println("1. Add a car");
            out.println("2. Remove a car");
            out.println("3. List all cars");
            out.println("4. Exit");
            option = input.nextInt();
            switch (option) {
                case 1:
                    CarRental.addCar(carRental.cars);
                    break;
                case 2:
                    CarRental.removeCar(carRental.cars);
                    break;
                case 3:
                    CarRental.listAllCars(carRental.cars);
                    break;
                case 4:
                    out.println("--------------------------------");
                    out.println("Thank you for using our service!");
                    out.println("--------------------------------");
                    break;
                case 420:
                    out.println("Shameless promotion: https://github.com/DiamondPRO02?tab=repositories");
                    break;
                default:
                    out.println("-------------------------------------");
                    out.println("---------- Invalid option! ----------");
                    break;
            }
        }
    }
}
