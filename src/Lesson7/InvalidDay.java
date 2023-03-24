package Lesson7;

public class InvalidDay extends Exception {

    public InvalidDay() {
    }

    public InvalidDay(String message) {
        super(message);
    }

    public InvalidDay(Throwable cause) {
        super(cause);
    }

    public InvalidDay(String message, Throwable cause) {
        super(message, cause);
    }

    /*
    public InvalidDay(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    */
}
