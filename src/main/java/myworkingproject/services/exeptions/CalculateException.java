package myworkingproject.services.exeptions;

public class CalculateException extends RuntimeException {
    public CalculateException(String message) {
        super(message);
    }
}
