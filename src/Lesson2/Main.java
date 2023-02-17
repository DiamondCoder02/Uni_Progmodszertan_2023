package Lesson2;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello World! ".repeat(100));
        /*
        Double String Float
        int - Integer
        char - Character
        boxing - converting primitive to object
        unboxing - converting object to primitive
        autoboxing - converting primitive to object automatically
        */

        // String -> int
        String text = "4";
        int number = Integer.parseInt(text);
        System.out.println(number);

        // int -> String
        int number2 = 5;
        String text2 = Integer.toString(number2);
        System.out.println(text2);
    }
}
