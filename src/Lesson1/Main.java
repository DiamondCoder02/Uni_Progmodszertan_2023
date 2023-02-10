package Lesson1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println('a');
        System.out.println("-----------------");

        byte b = (byte) 200;
        System.out.println(b);
        int b1 = 200;
        System.out.println(b1);
        System.out.println("-----------------");

        // One line comment
        /* 
         * Multi line comment
         * Multi line comment
        */
        /* 
        Also multi line comment
        Also multi line comment
        */
        /**
         * JavaDoc comment
         */

        float a = (float) 43.5;
        System.out.println(a+" NO");
        float a2 = 43.5f;
        float a3 = 43.5F;
        System.out.println(a2 + " f/F " + a3);
        double a1 = 43.5;
        System.out.println(a1 + " NO");
        System.out.println("-----------------");
        System.out.println(1 + 2 + "3");
        System.out.println(5.0/2);
        System.out.println("-----------------");

        String text = "This is a text";
        System.out.println(text);
        System.out.println(text.toUpperCase());
        System.out.println(text.toLowerCase());

        // challenge: write hello world 100 times without using a loop
        System.out.println("Hello World! ".repeat(100));

        // precedence of operators!!!
        // precedence of operators!!!
        // precedence of operators!!!
        
    }
}
