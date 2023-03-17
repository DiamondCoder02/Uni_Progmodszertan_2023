package Lesson6;

import java.util.ArrayList;
import java.util.List;

public class Dog extends mammal implements Animal{

    private String name;
    private String owner;
    private boolean isCute;

    private List<Dog> DogPlace = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isIsCute() {
        return isCute;
    }

    public void setCute(boolean cute) {
        isCute = cute;
        // this.isCute = cute;
    }

    @Override
    public void eat(String food) {
        System.out.println("Dog eats " + food);
    }

    @Override
    public void giveSound() {
        System.out.println("Dog says: Woof!");
    }
    
    public Dog(String name){
        this.name = name;
    }

    public Dog(String name, boolean cute){
        this.name = name;
        this.isCute = cute;
    }

    public Dog(){}

    public Dog(String species, String name, boolean cute){
        super(species);
        this.name = name;
        this.isCute = cute;
    }

    public void dogPlace(Dog dog){
        DogPlace.add(dog);
        System.out.println(dog.name + " is in a safe place.");
        System.out.println("Currently staying:");
        for (Dog doggy : DogPlace) {
            System.out.println(doggy.name);
        }
    }

    public void adoption(Dog dog){
        if(dog.isCute){
            DogPlace.remove(dog);
            System.out.println(dog.name + " is adopted.");
        } else {
            System.out.println(dog.name + " is not adopted.");
        }
        System.out.println("Currently staying:");
        for (Dog doggy : DogPlace) {
            System.out.println(doggy.name);
        }
    }
}
