package Lesson7;

public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            reserveDay(4);
        } catch (InvalidDay ex) {
            System.out.println(ex.getMessage());
        }
    }
    static void reserveDay(int day) throws InvalidDay {
        if(day < 1 || day > 7){
            throw new DayOutOfBoundException("Day is out of bound");
        }
        if(day == 6 || day == 7){
            throw new InvalidDay("Weekend is not allowed");
        } else{
            switch(day){
                case 1:
                    System.out.println("The reserved day is: Monday");
                    break;
                case 2:
                    System.out.println("The reserved day is: Tuesday");
                    break;
                case 3:
                    System.out.println("The reserved day is: Wednesday");
                    break;
                case 4:
                    System.out.println("The reserved day is: Thursday");
                    break;
                case 5:
                    System.out.println("The reserved day is: Friday");
                    break;
            }
        }
    }
}
