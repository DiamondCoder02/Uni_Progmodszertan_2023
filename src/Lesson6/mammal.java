package Lesson6;

public abstract class mammal {
    private String species;

    public void reproduction(){
        System.out.println("A mammal reproduces by giving birth to live young.");
    }

    public Mammal(String species){
        this.species = species;
    }

    public Mammal(){}

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

}
