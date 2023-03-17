package Lesson6;

public class mainDogHandle {
    public static void main(String[] args){
        Dog dog1 = new Dog("Fifike", true);
        Dog dog2 = new Dog("Cézár", false);

        dog1.giveSound();
        dog2.eat("meat");

        Dog dog3 = new Dog("Bodri", true);
        Dog dog4 = new Dog("Gay", false);

        Dog dogplace = new Dog();
        dogplace.dogPlace(dog1);
        System.out.println("-----------------");
        dogplace.dogPlace(dog2);
        System.out.println("-----------------");
        dogplace.dogPlace(dog3);
        System.out.println("-----------------");
        dogplace.dogPlace(dog4);
        System.out.println("-----------------");        
        System.out.println("-----------------");        

        dogplace.adoption(dog1);
        System.out.println("-----------------");
        dogplace.adoption(dog2);
        System.out.println("-----------------");
        dogplace.adoption(dog3);
        System.out.println("-----------------");
        dogplace.adoption(dog4);
        System.out.println("-----------------");
    }
}
