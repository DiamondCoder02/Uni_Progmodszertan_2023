package Lesson7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // int[][][] numbers = new int[100000][100000][100000];
        /*
        int[] numbers = new int[10];
        try {
            System.out.println(numbers[10]);
            System.out.println(13/0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException went wrong");
            System.out.println(e);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException went wrong");
            System.out.println(e);
        } finally {
            System.out.println("This will always run");
        }*/

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter a number: ");
            int value = scanner.nextInt();
            System.out.println("You entered: " + value);
        } catch(InputMismatchException e) {
            System.out.println("InputMismatchException went wrong");
            System.out.println(e);
        } finally {
            if (scanner != null){
                //scanner.close();
                System.out.println("Close scanner");
            }
            System.out.println();
        }

        try (Scanner scanner2 = new Scanner(System.in)) {
            System.out.println("Enter a number: ");
            int value2 = scanner2.nextInt();
            System.out.println("You entered: " + value2);
        } catch(InputMismatchException e) {
            System.out.println("InputMismatchException went wrong");
            System.out.println(e);
        }
    }
}
