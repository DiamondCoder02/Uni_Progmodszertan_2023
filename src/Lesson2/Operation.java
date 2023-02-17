package Lesson2;

public class Operation {
    public static void main(String[] args){
        boolean b1 = true;
        boolean b2 = false;
        boolean sum = b1 && b2;
        System.out.println(sum);
        boolean su = b1 || b2;
        System.out.println(su);

        int z = 100;
        boolean sum2 = b2 & z++ < 1000;
        System.out.println(sum2);
        System.out.println("-----------------");

        //post increment, pre increment
        int i = 10;
        int j = 20;
        System.out.println(i++ + ++j); // 10 + 21
        System.out.println(++i + j++); // 12 + 21
        System.out.println("-----------------");

        // conditinal operator
        // (condition) ? true : false
        int num = 234;
        System.out.println(num%2 == 0 ? "Even" : "Odd");

        String isEven = (num%2 == 0) ? "Even" : "Odd";
        System.out.println(isEven);
        System.out.println("-----------------");

        /*
        special year
        divide by 4, not devide by 100
        or divide by 400
        */
        int year = 2020;
        System.out.println(year%4 == 0 && year%100 != 0 || year%400 == 0 ? "Special" : "Normal");

        // can you edit the triangle?
        int a = 10;
        int b = 12;
        int c = 20;
        System.out.println(a+b > c && a+c > b && b+c > a ? "Yes" : "No");

        if(num%2==0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
        System.out.println("-----------------");

        // switch ( Since Java 12)
        int day = 2;
        switch(day) {
            case 1: System.out.println("Monday"); break;
            case 2: System.out.println("Tuesday"); break;
            case 3: System.out.println("Wednesday"); break;
            case 4: System.out.println("Thursday"); break;
            case 5: System.out.println("Friday"); break;
            case 6: System.out.println("Saturday"); break;
            case 7: System.out.println("Sunday"); break;
            default: System.out.println("Invalid day"); break;
        }

        String nameOfDay = switch(day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
        };
        System.out.println(nameOfDay);

        String fruit = "apple";
        String fruits = switch(fruit) {
            case "apple" -> "yes";
            case "banana" -> "no";
            case "dragonfruit" -> "maybe";
            default -> "Disgusting";
        };
        System.out.println(fruits);
        System.out.println("-----------------");
    }
}
