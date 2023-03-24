package Lesson7;

public class DayOutOfBoundException  extends InvalidDay{

    public DayOutOfBoundException() {
    }

    public DayOutOfBoundException(String message) {
        super(message);
    }

    public DayOutOfBoundException(Throwable cause) {
        super(cause);
    }

    public DayOutOfBoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
