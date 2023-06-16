package exceptions;

public class EventAlreadyStarted extends Exception{
    public EventAlreadyStarted(String message) {
        super(message);
    }
}
