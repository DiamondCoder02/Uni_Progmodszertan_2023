package Lesson5;

import java.util.ArrayList;
import java.util.List;

public class oop {
    public static void main(String[] args){
        Cat cica1 = new Cat();
            cica1.setName("Diamond");
            cica1.setAge(2);
            cica1.setColor(Color.BLACK);
            cica1.setBreed("Angóra");
            cica1.setSex("nőstény");
        System.out.println(cica1.getName());
        System.out.println(cica1.getAge());
        System.out.println(cica1.getColor());
        System.out.println("-----------------");

        Cat cica2 = new Cat("Cilike");
        System.out.println(cica2.getName());
        System.out.println("-----------------");

        Cat cica3 = new Cat("Nyaneko", 3, "Sziámi", "hím", Color.BROWN);
        System.out.println(cica3.getName());
        System.out.println(cica3.getAge());
        System.out.println(cica3.getBreed());
        System.out.println(cica3.getSex());
        System.out.println(cica3.getColor());
        System.out.println("-----------------");

        cica2.setBreed("Angóra");
        System.out.println(cica1.getBreed());
        System.out.println(cica2.getBreed());
        System.out.println(cica3.getBreed());
        System.out.println("-----------------");

        cica2.eatingHabit("fish");
        cica3.meow();
        System.out.println("-----------------");

        // static method
        Cat.safePlace(cica3);

        List<Cat> safePlace = new ArrayList<>();
        Cat.adoption(safePlace, cica3);
        System.out.println("-----------------");

        Cat miniCat = cica3.familyMake(cica1);
        System.out.println(miniCat.getName());
        System.out.println(miniCat.getAge());
        System.out.println(miniCat.getBreed());
        System.out.println(miniCat.getSex());
        System.out.println(miniCat.getColor());
        System.out.println("-----------------");

        Cat miniCat2 = Cat.familyMaking(cica3, cica1);
        System.out.println(miniCat2.getName());
        System.out.println(miniCat2.getAge());
        System.out.println(miniCat2.getBreed());
        System.out.println(miniCat2.getSex());
        System.out.println(miniCat2.getColor());
        System.out.println("-----------------");

        // Nope
        //cica1.CatHotelCheckIn(cica2);
        //cica2.CatHotelCheckIn(cica3);
        // Yes
        Cat hotelCat = new Cat();
        hotelCat.CatHotelCheckIn(cica1);

        hotelCat.CatHotelCheckIn(new Cat("Loki"));
        hotelCat.CatHotelCount();
        hotelCat.CatHotelCheckOut(new Cat("Loki"));
        hotelCat.CatHotelCount();
        System.out.println("-----------------");
    }
}
