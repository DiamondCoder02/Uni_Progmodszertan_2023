package Lesson2;

import java.util.Arrays;

public class Cycles {
    public static void main(String[] args) {
        /*
        for
        for each
        while
        do-while
        */

        // String books[] =
        String[] books = {"Java", "C + +", "Python", "C#", "JavaScript"};
        for(String book : books) {
            System.out.println(book);
        }
        for(int i=0; i < books.length; i++) {
            System.out.println(books[i]);
        }
        System.out.println("-----------------");

        int counter = 0;
        while(counter <=10){
            counter++;
            System.out.println(counter);
        }
        System.out.println("-----------------");
        
        int y = 1;
        while (true){
            y*=10;
            System.out.println(y + "  ");
            if(y > 1000) break;
        }
        System.out.println("-----------------");

        int x = 10;
        do {
            x*=5;
            System.out.println(x+"  ");
        } while(x < 1000);
        System.out.println("-----------------");

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] times = {"morning", "afternoon", "evening"};

outer:  for(String day : days) {
            System.out.println(day);
        for(String time : times) {
                if(day.equals("Wednesday")) break outer;
                System.out.println("  "+time);
            }
        }
        System.out.println("-----------------");

        int[] numbers2 = new int [10];

        numbers2[0] = 4;
        System.out.println(numbers2);
        System.out.println(Arrays.toString(numbers2));

        int[][] numbers3 = {{1,2,3},{4,5}};
        numbers3[0][2] = 43;
        System.out.println("-----------------");

        int[][][] moreNumbers = {
            {{1,2,3},{45}},
            {{67,76},{10,11,12}},
        };

        for (int[][] array2D : moreNumbers) {
            for (int[] array1D : array2D){
                for (int item : array1D){
                    System.out.println(item);
                }
            }
        }
    }
}
