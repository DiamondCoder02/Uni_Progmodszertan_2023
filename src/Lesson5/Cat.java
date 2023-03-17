package Lesson5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Cat {
    private String name;
    private int age;
    // private static String breed;
    private String breed;
    private String sex;
    private Color color;
    //private static List<Cat> safePlace = new ArrayList<>();
    private List<Cat> CatHotel = new ArrayList<>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    // Konstruktor

    public Cat(String name) {
        this.name = name;
    }
    public Cat(){
        
    }
    public Cat(String name, int age, String breed, String sex, Color color){
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.sex = sex;
        this.color = color;
    }

    public void eatingHabit(String food){
        System.out.println(this.name + " likes to eat " + food + ". :3");
    }
    public void meow(){
        System.out.println(this.name + " said Meow first at age " + this.age);
    }

    // Static method
    public static List<Cat> safePlace(Cat cica){
        List<Cat> safePlace = new ArrayList<>();
        safePlace.add(cica);
        System.out.println(cica.name + " is in a safe place.");
        return safePlace;
    }

    public static List<Cat> adoption(List<Cat> safePlace, Cat cica){
        safePlace.remove(cica);
        System.out.println(cica.name + " is adopted.");
        return safePlace;
    }

    // Static VS Dynamic
    public Cat familyMake(Cat mommyCat){
        int newBornAge = 0;
        String newBornBreed = mommyCat.getBreed();
        Random rnd = new Random();
        Color[] colors = {this.color, mommyCat.color};
        Color newBornColor = colors[rnd.nextInt(2)];
        String newBornName = this.name +" "+ mommyCat.getName();
        String[] genders = {"hím", "nőstény"};
        String newBornSex = genders[rnd.nextInt(2)];

        Cat newBorn = new Cat(newBornName, newBornAge, newBornBreed, newBornSex, newBornColor);
        return newBorn;
    }

    public static Cat familyMaking(Cat male, Cat female){
        int newBornAge = 0;
        String newBornBreed = female.getBreed();
        Random rnd = new Random();
        Color[] colors = {male.getColor(), female.color};
        Color newBornColor = colors[rnd.nextInt(2)];
        String newBornName = male.name +" "+ female.getName();
        String[] genders = {"hím", "nőstény"};
        String newBornSex = genders[rnd.nextInt(2)];

        Cat newBorn = new Cat(newBornName, newBornAge, newBornBreed, newBornSex, newBornColor);
        return newBorn;
    }

    // CatHotel
    public void CatHotelCheckIn(Cat cat){
        CatHotel.add(cat);
        System.out.println(cat.name + " is checked in.");
    }
    public void CatHotelCheckOut(Cat cat){
        for(int i = 0; i < CatHotel.size(); i++){
            if(CatHotel.get(i).name.equals(cat.name)){
                CatHotel.remove(CatHotel.get(i));
                System.out.println(cat.name + " is checked out.");
            }
        }
    }

    public void CatHotelCount(){
        System.out.println("Currently in hotel:");
        for(Cat cat : CatHotel){
            System.out.println(cat.name);
        }
    }
}
