package Lesson8_test.T2_Cars;

class Car {
    private Integer id;
    private String brand;
    private Integer year;
    private String color;

    // Generate getter & setter
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public Car(Integer id, String brand, Integer year, String color) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.color = color;
    }
}
