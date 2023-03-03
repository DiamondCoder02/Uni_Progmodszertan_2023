package Lesson4;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class methodAndClass {
    public static void main(String[] args) {
        out.println("----------------- Exercise 1 -----------------");
        // Polindrome();

        out.println("----------------- Exercise 2 -----------------");
        // exerciseTwo();

        out.println("----------------- Exercise 3 -----------------");
        //out.println(powerThree(10));

        out.println("----------------- Exercise 4 -----------------");
        // fromTenToThree();

        out.println("----------------- Exercise 5 -----------------");
        fromBaseToBase();
    }

    // Exercise 5
    public static void fromBaseToBase(){
        Scanner input = new Scanner(System.in);
        out.println("Please enter a number: ");
        Integer num = input.nextInt();
        out.println("Please enter a base to convert from Base10 to: ");
        Integer baseTo = input.nextInt();
        input.close();
        String result = "";
        while (num > 0) {
            result = num%baseTo + result;
            num /= baseTo;
        }
        out.println(result);
    }

    // Exercise 4
    public static void fromTenToThree(){
        Scanner input = new Scanner(System.in);
        out.println("Please enter a number: ");
        Integer num = input.nextInt();
        input.close();
        //from ten to three
        String result = "";
        while (num > 0) {
            result = num%3 + result;
            num /= 3;
        }
        out.println(result);
    }

    // Exercise 3
    public static List<Integer> powerThree(int n){
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add((int) Math.pow(3, i));
        }
        return list;
        
    }

    // Exercise 2
    public static void exerciseTwo(){
        Scanner input = new Scanner(System.in);
        out.println("Please enter a number for factorial and fibonacci: ");
        Integer num = input.nextInt();
        input.close();
        out.println("Factorial of " + num + " is " + Nfactorial(num));
        out.println("Fibonacci of " + num + " is " + Fibonacci(num));
    }
    public static int Fibonacci(int n){
        if (n <= 1) {
            return n;
        } else {
            return Fibonacci(n-1) + Fibonacci(n-2);
        }
    }
    public static int Nfactorial(int n){
        if (n <= 1) {
            return 1;
        } else {
            return n * Nfactorial(n-1);
        }
    }

    // Exercise 1
    private static void Polindrome() {
        Scanner input = new Scanner(System.in);
        out.println("Please enter text to test for polindrome: ");
        String text = input.nextLine();
        input.close();
        // get rid of useless characters
        String convertedText = text.toLowerCase().replace(" ", "").replace(",", "")
            .replace(".", "").replace("!", "").replace("?", "");

        for (int i = 0; i < convertedText.length(); i++) {
            if (convertedText.charAt(i) != convertedText.charAt(convertedText.length() - 1 - i)) {
                out.println("Not polindrome");
                return;
            }
        }
        out.println("Polindrome");
    }
}
